package com.yj.Jeans.repository;

import com.yj.Jeans.model.Freeboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Dao 선언 디비에 접근하는 객체 선언
public interface FreeboardRepository extends JpaRepository<Freeboard,Long>  {
                                 // extends 앞쪽은 엔티티이름 뒤쪽은 엔티티의 기본키타입
    Freeboard findByFreeid(Long freeid);

}
