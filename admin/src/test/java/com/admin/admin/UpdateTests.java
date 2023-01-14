package com.admin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Admin;
import com.admin.service.AdminService;

@SpringBootTest
class UpdateTests {

	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		Admin adm = new Admin(104,"best","best4321","베스트","주임",'A');
		try {
			service.modify(adm);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		
	}

}







