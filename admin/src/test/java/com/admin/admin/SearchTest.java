package com.admin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Admin;
import com.admin.service.AdminService;

@SpringBootTest
class SearchTest {

	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		Admin adm= null;
		try {
			adm = service.search("admid01");
			System.out.println(adm);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		
	}

}







