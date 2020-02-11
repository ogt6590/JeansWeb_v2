package com.yj.Jeans.service.userboard;

import com.yj.Jeans.repository.FreeboardRepository;
import com.yj.Jeans.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDeleteService {

    @Autowired
    UsersRepository usersRepository;

    public void delete(Long userid){
        usersRepository.deleteById(userid);//유저 삭제 메소드
    }
}