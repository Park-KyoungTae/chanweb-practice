package com.admin.admin;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Admin;
import com.admin.dto.Criteria;
import com.admin.mapper.AdminMapper;

@SpringBootTest
class AdminPagingTest {
	
	@Autowired
	AdminMapper mapper;
	
	@Test
	void contextLoads() {
		Criteria cri = new Criteria();
		try {
			List<Admin> adms = mapper.getListByPaging(cri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}







