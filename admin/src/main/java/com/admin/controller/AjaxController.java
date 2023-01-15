package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dto.Admin;
import com.admin.service.AdminService;

@RestController
public class AjaxController {

	@Autowired
	AdminService admservice;
	
	@RequestMapping("/checkid")
	public Object checkid(String id) {
		int result = 0;
		Admin adm = null;
		
		try {
			adm = admservice.search(id);
			if(adm == null) {
				result = 1;
			}else {
				result = 0;
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		return result;
	}
}
