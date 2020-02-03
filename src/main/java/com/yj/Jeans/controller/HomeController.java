package com.yj.Jeans.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller     //페이지 넘겨준는 곳
public class HomeController {

    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/joinPage")
    public String joinPage(){
        return "join";
    }

    @GetMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        session.invalidate(); //로그아웃하면 session에 모든것을 지운다
        return "index";
    }

    @GetMapping("/freeboardWritePage")
    public String freeboardWritePage(){
        return "freeboardWrite";
    }

}
