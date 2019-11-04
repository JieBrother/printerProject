package org.lwh.printer.controller;

import org.lwh.printer.pojo.User;
import org.lwh.printer.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/test")
    public @ResponseBody
    String test(String userName, String password) {
//        List<Admin> list = adminService.testDao();
        System.out.println(userName + " " + password);
        return "haha";
    }

    @RequestMapping(value = "/login", produces = "application/json; charset=utf-8")
    public String login(User user, HttpSession session, HttpServletResponse response) throws IOException {
//        System.out.println(user);
        User loginUser = userService.login_admin(user);
        if (loginUser != null) {
            session.setAttribute("user", loginUser);
            System.out.println("Controller: " + user);
            System.out.println("到这里了");
            return "redirect:/adminHomePage";
        } else {
            loginUser = userService.login_user(user);
            if (loginUser != null) {
                session.setAttribute("user", loginUser);
                System.out.println("Controller: " + loginUser);
//                response.sendRedirect("/html/login.html");
                return "redirect:/welcome";

            } else {
//                response.sendRedirect("/html/login.html");
                return "redirect:/";

            }
        }
    }

    @RequestMapping("/logoutAction")
    public String logoutAction(HttpSession session) {
        session.invalidate();
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/register", produces = "application/json; charset=utf-8")
    public String register(User user) {
        if (userService.register_user(user)) {
            return "redirect:/html/login.html";
        }
        return "redirect:/html/register.html";
    }

}
