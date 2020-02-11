package com.yj.Jeans.service.freeboard;

import com.yj.Jeans.PageMaker.PageMaker;
import com.yj.Jeans.model.Freeboard;
import com.yj.Jeans.repository.FreeboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Service
public class FreeboardListService {

    @Autowired
    private FreeboardRepository freeboardRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private PageMakerService pageMakerService;

    //현재 페이지 번호를 FreeboardController에게서 매개변수로 받는다.
    public String freeboardList(int pageNum){

        PageMaker pageMaker =pageMakerService.generatePageMaker(pageNum,10,freeboardRepository);//pageMakerService에서 자동으로 -1해준다.
                                                                        //contentNum 게시글최대 개수
        PageRequest pageRequest=PageRequest.of(pageNum-1,10,Sort.Direction.DESC,"freeid" );
        //PageRequest 정렬 방향과 속성을 적용하여 새로 만듭니다.
        Page<Freeboard> freeboardPage =freeboardRepository.findAll(pageRequest);
                                        // findAll디비에서 전체 페이지정보 가져오기 size:10은 글내용이 10개다

        if(freeboardPage.getSize()==0){   // 0이면  가져올 게시글이 없다

            session.setAttribute("boardList",new ArrayList<Freeboard>());
            //추측 freeboard.html에서 boardList 세션 사용
            //null값주면 페이지에러떠서 값을 0으로 준다
            session.setAttribute("pageMaker",pageMaker);
            //추측 freeboard.html 에서 pageMaker 세션 사용
             return "freeboard";
        }

        List<Freeboard> freeboardList =freeboardPage.getContent();
        //getContent 프리보드 게시판에 모든 정보를 가져온다
        session.setAttribute("boardList",freeboardList);
        //게시판 정보를 세션에 넣기
        session.setAttribute("pageMaker",pageMaker);

        return "freeboard";
    }
}