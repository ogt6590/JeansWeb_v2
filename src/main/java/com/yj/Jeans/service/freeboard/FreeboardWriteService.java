package com.yj.Jeans.service.freeboard;

import com.yj.Jeans.model.Freeboard;
import com.yj.Jeans.repository.FreeboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeboardWriteService {
  //게시판 디비에 저장하는 서비스
    @Autowired
    FreeboardRepository freeboardRepository;

    public void write(String title,String content,String writer){
        Freeboard freeboard=new Freeboard();
        freeboard.setTitle(title);
        freeboard.setContent(content);
        freeboard.setWriter(writer);
        freeboardRepository.save(freeboard);  //html 에서 입력한 값을 게시판 디비에 저장
    }

}
