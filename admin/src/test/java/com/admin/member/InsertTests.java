package com.admin.member;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Member;
import com.admin.service.MemberService;

@SpringBootTest
class InsertTests {

	@Autowired
	MemberService service;
	
	@Test
	void contextLoads() {
		Date date = new Date();
		Member mem = new Member(0,"id04","pwd04","박경태","kt@naver.com","010-3333-3333",'A','A',date,null);
		try {
			service.register(mem);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		
	}

}







