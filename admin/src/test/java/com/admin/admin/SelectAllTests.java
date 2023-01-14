package com.admin.admin;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Admin;
import com.admin.service.AdminService;

@SpringBootTest
class SelectAllTests {

	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		List<Admin> adms = null;
		try {
			adms = service.getall();
			for(Admin a:adms) {
				System.out.println(a);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
		
	}

}







