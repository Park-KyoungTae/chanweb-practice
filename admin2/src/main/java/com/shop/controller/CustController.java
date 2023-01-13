package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.Cust;
import com.shop.service.CustService;

@Controller
@RequestMapping("/cust")
public class CustController {

	String dir = "cust/";
	
	@Autowired
	CustService cservice;

	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"center");
		return "main";
	}
	
	@RequestMapping("/register")
	public String register(Model model, Cust cust) {
		try {
			cservice.register(cust);
			model.addAttribute("obj", cust);
			model.addAttribute("center", dir+"registerok");
		} catch (Exception e) {
			model.addAttribute("center", dir+"registerfail");
			e.printStackTrace();
		}
		model.addAttribute("left", dir+"left");
		
		return "main";
	}

	@RequestMapping("/getall")
	public String getall(Model model) {
		List<Cust> list = null;
		try {
			list = cservice.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("clist",list);
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"getall");
		return "main";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"add");
		return "main";
	}
	
	@RequestMapping("/get")
	public String get(Model model, String id) {
		
		Cust c = null;
		try {
			c = cservice.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("obj", c);
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"get");
		return "main";
	}
	
	@RequestMapping("/update")
	public String update(Model model, Cust cust) {
		try {
			cservice.modify(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:get?id="+cust.getId();
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, String id) {
		try {
			cservice.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:getall";
	}
	
}











