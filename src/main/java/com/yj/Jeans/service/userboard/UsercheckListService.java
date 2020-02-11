package com.yj.Jeans.service.userboard;

import com.yj.Jeans.model.Users;
import com.yj.Jeans.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsercheckListService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private HttpSession session;

    public String showUsers(){

        PageRequest pageRequest=PageRequest.of(0,10, Sort.Direction.DESC,"id"); //properties 아이디 기준정렬 세운다
        Page<Users> users = usersRepository.findAll(pageRequest);
        //위에 기준으로 된게 아래에 들어갔다

        if(users.getSize()==0){
            session.setAttribute("userList",new ArrayList<Users>());
            return "adminusers";
        }

        List<Users> UserList=users.getContent();
        session.setAttribute("userList",UserList);
        return "adminusers";
    }
}