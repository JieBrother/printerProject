package org.lwh.printer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@RequestMapping("/html")
@Controller
public class MainPageController {
    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Object loginStatuc = httpServletRequest.getSession().getAttribute("user");
        if (loginStatuc == null) {
            return "redirect:/";
        } else
            return "/homePage";
    }

    @RequestMapping("/addPrintPage")
    public String addPrintPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Object loginStatuc = httpServletRequest.getSession().getAttribute("user");
        if (loginStatuc == null) {
            return "redirect:/";
        } else
            return "/addPrintPage";
    }

    @RequestMapping("/historyPage")
    public String historyPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Object loginStatuc = httpServletRequest.getSession().getAttribute("user");
        if (loginStatuc == null) {
            return "redirect:/";
        } else
            return "/historyPage";
    }

    @RequestMapping("/adminHomePage")
    public String adminHomePage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Object loginStatuc = httpServletRequest.getSession().getAttribute("user");
        if (loginStatuc == null) {
            return "redirect:/";
        } else
            return "/adminHomePage";
    }

    @RequestMapping("/adminHistoryPage")
    public String adminHistoryPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Object loginStatuc = httpServletRequest.getSession().getAttribute("user");
        if (loginStatuc == null) {
            return "redirect:/";
        } else
            return "/adminHistoryPage";
    }

}
