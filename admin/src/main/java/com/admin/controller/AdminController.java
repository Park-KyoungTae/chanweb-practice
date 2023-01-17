package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.dto.Criteria;
import com.admin.dto.Page;
import com.admin.service.AdminService;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@Autowired
	AdminService admservice;
	
	String dir ="list/";
	
	@GetMapping("/list")
	public String get(Model model, 
				@RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
				@RequestParam(value="amount", defaultValue="10") Integer amount
				) {
		Criteria cri = new Criteria(pageNum,amount);
		
		try {
			model.addAttribute("admin",admservice.getListByPaging(cri));
			model.addAttribute("pageMaker", new Page(cri,admservice.getTotal()));
		} catch (Exception e) {
//			e.printStackTrace();
		}
		model.addAttribute("center",dir+"admin");
		return "main";
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(int del) {
		try {
			admservice.remove(del);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return "main";
	}
	
	@ResponseBody
	@RequestMapping("/approval")
	public String approval(int apr) {
		try {
			admservice.changeStatus(apr);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return "main";
	}
}
