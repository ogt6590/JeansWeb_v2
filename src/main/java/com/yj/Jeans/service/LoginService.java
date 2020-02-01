package com.yj.Jeans.service;


import com.yj.Jeans.model.Users;
import com.yj.Jeans.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    private UserPasswordhashClass userPasswordhashClass;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    HttpSession session;

    public String login(String userId,String userPw){

        if(userId.equals("")||userPw.equals("")){
            return "login";
        }    // 둘중하나 null 값이면 다시 로그인 페이지로

       String hashedPassword = userPasswordhashClass.getSHA256(userPw);   // 해쉬패스워드 값받기

        Users users=usersRepository.findByUseridAndPassword(userId,hashedPassword);
        //디비에서 입력받은값이랑 일치하는 아이디 해쉬비밀번호 찾아서 넘겨주기

        if(users==null){
            return "login";  //디비에서 못찾으면 null 값이니까 다시 로그인 페이지로
        }

        session.setAttribute("loginUser",users); //세션에속성을 정해줌 세션을 만들기위헤 name에 ,vlaue[users]값할당

        return "index";  //로그인하여 기본페이지로
    }

}
