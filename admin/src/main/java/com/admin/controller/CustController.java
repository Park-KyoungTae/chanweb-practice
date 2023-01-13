package com.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cust")
@Controller
public class CustController {
	
	String dir ="cust/";
	
	@RequestMapping("/get")
	public String get(Model model) {
		model.addAttribute("center",dir+"get");
		return "main";
	}
}
	