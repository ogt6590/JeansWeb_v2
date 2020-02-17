package com.yj.Jeans.repository;

import com.yj.Jeans.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    Users findByUseridAndPassword(String userId,String userPw); //유저아이디 패스워드 받아서 데이터 베이스 같은 유저를 넘겨줌
                                                                //레포지토리애서 값은값을 찾아야하므로 사용
    Users findById(String id);
}
