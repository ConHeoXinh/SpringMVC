/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.controller;

import com.fpt.pojo.User;
import com.fpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author quant
 */
@Controller
public class UserController {
    @Autowired
    private UserService userDetialsService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(value = "user") User user, Model model) {
        if (user.getPassword().isEmpty() || !user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("errMsg", "mat khau deu khop dau");
        } else {
            if(this.userDetialsService.addUser(user) == true){
                return "redirect:/login";
            }
            model.addAttribute("errMsg", "da co loi xay ra vui long quay lai sau");
        }
        return "register";
    }
}
