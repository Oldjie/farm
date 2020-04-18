package com.xuli.farm.controller;


import com.github.pagehelper.PageInfo;
import com.xuli.farm.po.News;
import com.xuli.farm.po.ResultInfo;
import com.xuli.farm.po.User;
import com.xuli.farm.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")

public class NewsController {
    @Autowired
    private NewsServiceImpl newsService;

    @GetMapping("admin/news.html")
    public String news(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageInfo<News> pageBean = newsService.queryUserAll(pageNum, pageSize);

        model.addAttribute("news", pageBean);
        return "admin/news";
    }

    @GetMapping("admin/addNews.html")
    public String news() {

        return "admin/addNews";
    }

    @PostMapping("admin/updateNews.html")
    @ResponseBody
    public ResultInfo updateNews(News news) {
        ResultInfo resultInfo = null;
        Boolean flag = newsService.updateUser(news);
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;

    }

    @PostMapping("admin/del_news")
    @ResponseBody
    public ResultInfo delNews(News news) {
        ResultInfo resultInfo = null;
        Boolean flag = newsService.deleteUserById(news.getId());
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;
    }

    @GetMapping("news.html")
    public String show_news(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        PageInfo<News> news = newsService.queryUserAll(pageNum, pageSize);

        model.addAttribute("news", news);
        return "home/news";
    }

    @PostMapping("admin/save_news.html")
    @ResponseBody
    public ResultInfo saveNews(News news) {
        ResultInfo resultInfo = null;
        Boolean flag = newsService.insertNews(news);
        resultInfo = new ResultInfo(flag, null, null);
        return resultInfo;

    }

    @GetMapping("admin/editNews.html")
    public String editNews(Model model, @RequestParam(value = "uid") int uid) {
        News news = newsService.queryUserById(uid);
        model.addAttribute("news", news);
        return "admin/editNews";

    }


    @GetMapping("details.html")
    public String user(Model model, @RequestParam(value = "uid") int uid) {
        News news = newsService.queryUserById(uid);
        model.addAttribute("news", news);

        return "home/details";
    }

    @GetMapping("more.html")
    public String more(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        PageInfo<News> news = newsService.queryUserAll(pageNum, pageSize);

        model.addAttribute("news", news);
        return "home/more";
    }


}
