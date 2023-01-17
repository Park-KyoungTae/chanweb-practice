package com.admin.member;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Admin;
import com.admin.dto.Member;
import com.admin.service.MemberService;

@SpringBootTest
class SelectAllTests {

	@Autowired
	MemberService service;
	
	@Test
	void contextLoads() {
		List<Member> mems = null;
		try {
			mems = service.getall();
			for(Member m:mems) {
				System.out.println(m);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		
	}

}







