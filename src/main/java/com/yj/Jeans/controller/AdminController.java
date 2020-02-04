package com.yj.Jeans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @GetMapping("/adminIndex")
    public String index(){
        return "adminIndex";
    }//관리자 인덱스페이지로

    @GetMapping("/adminusers")
    public String userList(){
        return "adminUsers";
    }//유저 목록홈페이지로

}
