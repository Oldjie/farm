package com.xuli.farm.controller;

import com.baidu.ueditor.ActionEnter;
import com.xuli.farm.dto.UEditorResult;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("ueditor")
public class UeditorController {


    @RequestMapping(value = "/config")

    public void config(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("application/json");

        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/ueditor/jsp";


        try {

            response.setCharacterEncoding("UTF-8");

            String exec = new ActionEnter(request, rootPath).exec();
//            System.out.println(exec);

            PrintWriter writer = response.getWriter();

            writer.write(new ActionEnter(request, rootPath).exec());

            writer.flush();

            writer.close();


        } catch (IOException e) {

            e.printStackTrace();

        }

    }


}
