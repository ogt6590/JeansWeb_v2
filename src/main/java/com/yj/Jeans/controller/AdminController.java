package com.yj.Jeans.controller;


import com.yj.Jeans.service.userboard.UserDeleteService;
import com.yj.Jeans.service.userboard.UsercheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//관라자 용 컨트롤러
@Controller
public class AdminController {

    @Autowired
    UsercheckListService UsercheckList;

    @Autowired
    UserDeleteService userDeleteService;

    //문자열 값을 매개변수로 받은 걸 인트로 반환
    private int returnIntValue(String stringToInt){
         return Integer.parseInt(stringToInt);
    }

    @GetMapping("/adminusers")
    public String userList(@RequestParam(value="userpageNum",defaultValue = "1")String userpageNum){
    //userpageNum 세션은 기본이 1이다.
       String page= UsercheckList.showUsers(returnIntValue(userpageNum));//UsercheckList서비스로 보낸다.
       return page;
    }

    @GetMapping("userDelete")
    public String userDelete(@RequestParam("userid")Long userid) {
        userDeleteService.delete(userid);
        return "redirect:/adminusers";
    }
}
