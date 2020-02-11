package com.yj.Jeans.service;

import com.yj.Jeans.model.Users;
import com.yj.Jeans.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 로직 처리부분
@Service
public class JoinService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserPasswordhashClass userPasswordhashClass;

    public  String joinUser(String userId,String userPw ,String userName) {

        if(userId.equals("") || userPw.equals("") || userName.equals("") ){
            return "join";  //하나라도 null 값이면 다시 회원가입으로 넘어가라
        }

        Users users=new Users(); //디비객체생성
        users.setUserid(userId);
        users.setRole(1);//회원은 무조건 역할값이 1이다.
        String hashedPassword=userPasswordhashClass.getSHA256(userPw); //패스워드를 해쉬로 바꿔서 넘겨줌
        users.setPassword(hashedPassword);
        users.setUsername(userName);


        usersRepository.save(users); //세이브 디비에 저장하는 함수
        return "index";   //회원가입 하여 기본 페이지로 넘어감
    }

}
