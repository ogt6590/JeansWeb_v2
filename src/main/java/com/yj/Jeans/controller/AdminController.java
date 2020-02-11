package com.yj.Jeans.controller;


import com.yj.Jeans.service.userboard.UsercheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    UsercheckListService UsercheckList;

    private int returnIntValue(String stringToInt){
         return Integer.parseInt(stringToInt);
    }

    @GetMapping("/adminusers")
    public String userList(){
       String page= UsercheckList.showUsers();
        return page;
    }
}
