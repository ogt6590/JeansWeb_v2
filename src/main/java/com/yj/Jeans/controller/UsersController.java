package com.yj.Jeans.controller;

import com.yj.Jeans.service.JoinService;
import com.yj.Jeans.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//서비스랑 이어주는 역할
//로그인이랑 회워가입 서비스 연결역할
@Controller
public class UsersController {


    @Autowired
    private JoinService joinService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/joinRequest")   //@RequestParam은 맵형식으로 정보를 받아오고 null값이면 오류가뜬다
    public String joinRequest(@RequestParam Map<String,String> paramMap){
        //웹페이지에 있는 모든정보를 저장 paramap에
        String userId=paramMap.get("user_id");
        String userPw=paramMap.get("user_pw");
        String userName=paramMap.get("user_name");


        String page=joinService.joinUser(userId,userPw,userName);   //join html 에서 값받은걸 join 서비스로 넘겨줌
        //joinuser 메소드에 null값 오류제어 있음
        return page;
    }

    @PostMapping("/loginRequest")
    public String loginRequest(@RequestParam Map<String,String>paraMap){
        String userId=paraMap.get("user_id");
        String userPw=paraMap.get("user_pw");

        String page=loginService.login(userId,userPw);

        return page;  //받은값 페이지로 넘어감
    }
}


/*
비밀번호 만들때
123456789->123456789
123456789-> 해싱함   못알아보게
 */