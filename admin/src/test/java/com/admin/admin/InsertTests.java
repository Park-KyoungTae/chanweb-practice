package com.admin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Admin;
import com.admin.service.AdminService;

@SpringBootTest
class InsertTests {

	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		Admin admin = new Admin(0,"best","best1234","베스트","대리",'A');
		try {
			service.register(admin);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		
	}

}







