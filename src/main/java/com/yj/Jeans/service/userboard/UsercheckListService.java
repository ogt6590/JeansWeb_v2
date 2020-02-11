package com.yj.Jeans.service.userboard;

import com.yj.Jeans.PageMaker.userPageMaker;
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
    //유저목록 서비스 관리자가 Web에서 현재 유저목록들을 확인할수 있도록 도와준다.
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private userPageMakerService userPageMakerService;

    public String showUsers(int pageNum){//pageNum이라는 int 값을 매개변수로 받는다.
        userPageMaker userPageMaker=userPageMakerService.generatePageMaker(pageNum,10,usersRepository);

        PageRequest pageRequest=PageRequest.of(pageNum-1,10, Sort.Direction.DESC,"id"); //properties 아이디 기준정렬 세운다

        Page<Users> users = usersRepository.findAll(pageRequest);
        //위에 기준으로 된게 아래에 들어갔다

        if(users.getSize()==0){
            session.setAttribute("userList",new ArrayList<Users>());
            session.setAttribute("userpageMaker",userPageMaker);
            return "adminusers";
        }

        List<Users> UserList=users.getContent();
        session.setAttribute("userList",UserList);
        session.setAttribute("userpageMaker",userPageMaker);
        return "adminusers";
    }
}