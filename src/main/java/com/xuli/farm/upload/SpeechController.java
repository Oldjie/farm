package com.xuli.farm.upload;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

@RestController
@RequestMapping("/speech")
//@Slf4j
public class SpeechController {
    @Autowired
    private UploadFilePathConfig filePathConfig;

    /**
     * 提供KindEditor作文件上传使用
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @PostMapping("/uploadFile")
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PrintWriter writer = response.getWriter();
        // 文件保存目录路径
        String savePath = filePathConfig.getUploadFolder();

        String saveUrl = filePathConfig.getBaseUrl() + File.separatorChar + "static/image" + File.separatorChar;

        // 定义允许上传的文件扩展名
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");

        // 最大文件大小
        long maxSize = 1000000;
        response.setContentType("text/html; charset=UTF-8");

        if (!ServletFileUpload.isMultipartContent(request)) {
//            writer.println(getError("请选择文件。"));
            return;
        }

        File uploadDir = new File(savePath);
        // 判断文件夹是否存在,如果不存在则创建文件夹
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 检查目录写权限
        if (!uploadDir.canWrite()) {
//            writer.println(getError("上传目录没有写权限。"));
            return;
        }

        String dirName = request.getParameter("dir");
        if (dirName == null) {
            dirName = "image";
        }
        if (!extMap.containsKey(dirName)) {
//            writer.println(getError("目录名不正确。"));
            return;
        }

        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = mRequest.getFileMap();
        String fileName = null;
        for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, MultipartFile> entry = it.next();
            MultipartFile mFile = entry.getValue();
            fileName = mFile.getOriginalFilename();
            // 检查文件大小
            if (mFile.getSize() > maxSize) {
//                writer.println(getError("上传文件大小超过限制。"));
                return;
            }
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
//                writer.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
                return;
            }
            UUID uuid = UUID.randomUUID();
            String path = savePath + uuid.toString() + "." + fileExt;
            saveUrl = saveUrl + uuid.toString() + "." + fileExt;

            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path));
            FileCopyUtils.copy(mFile.getInputStream(), outputStream);

//            log.info("【提交图片】参数正确, saveUrl={}", saveUrl);
            JSONObject obj = new JSONObject();
            obj.put("error", 0);
            obj.put("url", saveUrl);
            writer.println(obj.toString());

        }

    }
}


