package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/user")
@SessionAttributes({"username"})
public class UserController {
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String login(String username, String password, Model m){
        if(username.equals("root")&&password.equals("root")){
            m.addAttribute("user","root");
            return "redirect:../main.jsp";
        }else{
            return "redirect:../index.jsp";
        }
    }
}
