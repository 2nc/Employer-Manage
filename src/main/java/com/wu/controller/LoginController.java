package com.wu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password, Model model, HttpSession session) {

        //Validate user
        if (!StringUtils.isEmpty(email) && "123".equals(password)) {
            session.setAttribute("loginUser", email);
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "Wrong username or password");
        }
        return "index";

    }


}
