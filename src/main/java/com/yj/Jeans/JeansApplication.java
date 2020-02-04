package com.yj.Jeans;


import com.yj.Jeans.model.Users;
import com.yj.Jeans.repository.UsersRepository;
import com.yj.Jeans.service.UserPasswordhashClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JeansApplication {

	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private UserPasswordhashClass userPasswordhashClass;

	public static void main(String[] args) {

		SpringApplication.run(JeansApplication.class, args);
	}
/*
	@PostConstruct
	public void initAdmin(){
		Users users= Users.builder()
				.userid("admin")
				.username("관리자")
				.password(userPasswordhashClass.getSHA256("1234"))
				.role(0)
				.build();
		userRepository.save(users);
	}//유저 추가 주석 다시 껏다 킬때 주석 처리 필요
*/
}

