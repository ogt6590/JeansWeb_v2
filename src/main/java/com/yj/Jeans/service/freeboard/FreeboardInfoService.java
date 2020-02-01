package com.yj.Jeans.service.freeboard;


import com.yj.Jeans.model.Freeboard;
import com.yj.Jeans.repository.FreeboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class FreeboardInfoService {
        //게시글 내용보는역할 클래스
    @Autowired
    private FreeboardRepository freeboardRepository;

    @Autowired
    private HttpSession session;

    public String getFreeboardPost(String stringFreeId){
            //게시글번호 넘겨주는 메소드
        Long freeid=Long.parseLong(stringFreeId);  //문자열값을 long형으로 바꿈
        Freeboard freeboard=freeboardRepository.findByFreeid(freeid);  //레포지토리에 기본키넘기고
        if(freeboard==null){
            return "freeboard";  //같은게 없으면 게시판 으로감
        }

        session.setAttribute("freeboard",freeboard);
        //지금보고있는 글정보를 저장한다

        return "freeBoardInfo";   //같은게 있으면 글정보 내용불러옴

    }

}
