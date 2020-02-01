package com.yj.Jeans.repository;

import com.yj.Jeans.model.Freeboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //  디비랑 연결하는 기능을 부여 엔티티 매니저 트랜잭션 자동으로 해줌 설명자세히는 없음
public interface FreeboardRepository extends JpaRepository<Freeboard,Long>  {
     // extends 앞쪽은 클레스이름 뒤쪽은 클래스의 기본키타입
    Freeboard findByFreeid(Long freeid);  //디비에 기본키 넘겨서 디비에 같은 값을 가진거를 찾음
                                        //레포지토리애서 값은값을 찾아야하므로 사용

}
