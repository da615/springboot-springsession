package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {
    @GetMapping("/set")
    public String setSession(HttpSession session){
        session.setAttribute("url","https://www.baidu.com");
        return "ok";
    }

    @GetMapping("/get")
    public String getSession(HttpSession session){
        String s = (String)session.getAttribute("url");
        System.out.println(s);
       return (String)session.getAttribute("url");
    }
}
