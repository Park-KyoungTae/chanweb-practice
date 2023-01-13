package com.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.Cust;
import com.shop.service.CustService;

@Controller
public class MainController {
	
	@Autowired
	CustService cservive;
	
	// http://127.0.0.1/
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", "login");
		return "main";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "main";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(HttpSession session, String id, String pwd, Model model) {
		Cust cust = null;
		String result = "loginfail";
		try {
			cust = cservive.get(id);
			if(cust != null) {
				if(cust.getPwd().equals(pwd)) {
					// 성공	
					result = "loginok";
					session.setAttribute("logincust", cust);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", result);
		return "main";
	}
}










