package com.yj.Jeans.controller;

import com.yj.Jeans.service.freeboard.FreeboardDeleteService;
import com.yj.Jeans.service.freeboard.FreeboardInfoService;
import com.yj.Jeans.service.freeboard.FreeboardListService;
import com.yj.Jeans.service.freeboard.FreeboardWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//controller view 화면 리턴이 주목적

@Controller
public class FreeboardController {

    @Autowired   //객체를 컨테이너가 자동으로 생성하고 빈(컨테이너가 만든객체)을주입한다
    private FreeboardListService freeboardListService;   //게시판리스트 보여주는기능
    @Autowired
    private FreeboardWriteService freeboardWriteService;  //게시판 작성  글쓰기 기능 부분
    @Autowired
    private FreeboardDeleteService freeboardDeleteService;  //게시판 삭제 기능 부분
    @Autowired
    private FreeboardInfoService freeboardInfoService;   //게시글 작성글내용 연결역할

    private int returnIntValue(String stringToInt){
        return Integer.parseInt(stringToInt);   //글자값받아서 숫자로변환
    }

    @GetMapping("/freeboard")//  해당 url 요청시 리턴 인덱스 반환
    public String freeboard(@RequestParam(value="pageNum",defaultValue="1")String pageNum){
        //https://heavenly-appear.tistory.com/302  값이존재하진않으면 400 에러 defaultvalue=기본값 value 데이터이름
        String page =freeboardListService.freeboardList(returnIntValue(pageNum));

        return page; //게시판으로 화면이동
    }

    @PostMapping("/freeboardWriteRequest") //post 접근할때 값 리턴
    public String freeboardWriteRequest(@RequestParam Map<String,String> paramMap){
        //받아올 정보가많을때 위에는 pagaNum하나만 들고오면 되지만
        //아래처럼 title content writer 처럼 여러개 받아올때는
        // Map 형식으로 대량으로 받아옴
        // 단점이 개발한사람외에 사람이알아먹기 힘듬
        String title=paramMap.get("title");
        String content=paramMap.get("content");
        String writer=paramMap.get("writer");
        freeboardWriteService.write(title,content,writer);

        return "redirect:/freeboard";
        //내가게시글 작성후 다시 게시글을 내가쓴거 포함해서 리다이렉트로  불러옴
    }



    @GetMapping("/freeBoardInfo")   //freeBoardInfo 게시글 보는역할
    public String getPost(@RequestParam(value = "freeid")String freeid){
        //freeid 는 1번글 2번글 3번글 게시글번호
        String page=freeboardInfoService.getFreeboardPost(freeid);
        //page==freeBoardInfo?freeid="+freeid page에들어감 freeboard html에서
        return page;
    }               // 글내용 클릭했을떄 그 내용을 반환



    @GetMapping("delete")
    public String delete(@RequestParam("FreeId")Long FreeId) {//매개변수로 그 페이지 FreeId를 Long으로 받아온다.
        freeboardDeleteService.delete(FreeId);

        return "redirect:/freeboard";
        //내가쓴거 포함해서 리다이렉트로  불러옴
 //FreeboardInfo.html에서 delete스크립트문 사용->FreeboardController->FreeboardDeleteService->FreeboardRepository.deleteById사용
    }

}