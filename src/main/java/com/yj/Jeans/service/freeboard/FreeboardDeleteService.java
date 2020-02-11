package com.yj.Jeans.service.freeboard;

import com.yj.Jeans.model.Freeboard;
import com.yj.Jeans.repository.FreeboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeboardDeleteService {
    //게시판 디비에 저장하는 서비스
    @Autowired
    FreeboardRepository freeboardRepository;

    public void delete(Long freeId){

        freeboardRepository.deleteById(freeId);//삭제 메서드....

    }
}