package com.yj.Jeans.service.freeboard;

import com.yj.Jeans.PageMaker.PageMaker;
import com.yj.Jeans.model.Freeboard;
import com.yj.Jeans.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PageMakerService {

    //pageNum은 현재 몇 페이지인지. contentNum은 한 페이지 당 최대 글 개수.
    public PageMaker generatePageMaker(int  pageNum, int contentNum, JpaRepository<Freeboard,Long>repository){
        PageMaker pageMaker=new PageMaker();

        int totalCount=(int)repository.count();//count 엔티티의 수를 int 값으로 반환한다.
        pageMaker.setTotalcount(totalCount); //전체 게시글 수를 지정한다.
        pageMaker.setPagenum(pageNum-1);//현재 페이지를 페이지 객체에 지정한다. -1를 해야 쿼리에서 사용할수 있다
        pageMaker.setContentnum(contentNum); //한페이지에 몇개씩 게시글을 보여줄지 지정한다.
        pageMaker.setCurrentBlock(pageNum);//현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
        pageMaker.setLastblock(pageMaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서 정한다
        pageMaker.prevnext(pageNum);//현재 페이지 번호로 화살표를 나타낼지 정한다
        pageMaker.setStartPage(pageMaker.getCurrentblock());//시작페이지를 페이지롤 블록번호를 정한다
        pageMaker.setEndPage(pageMaker.getLastblock(),pageMaker.getCurrentblock());//마지막페이지를 마지막 페이지 블록과
                                                                //현재페이지 블록 번호로 정한다

        return pageMaker;
    }
}

//JpaRepository 에 관하여 https://araikuma.tistory.com/329