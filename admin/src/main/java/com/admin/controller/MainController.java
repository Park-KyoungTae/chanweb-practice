package com.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.Admin;
import com.admin.service.AdminService;

@Controller
public class MainController {
	
	@Autowired
	AdminService admservice;
	
	@RequestMapping("/main")
	public String main(HttpSession session) {
		try {
			String status = (String) session.getAttribute("login_status");
			if(status!="Y" || status==null){
				return "redirect:/login";
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@RequestMapping("/loginadmin")
	public String loginiadmin(HttpSession session, String id, String pwd, Model model) {
		Admin adm = null;
		try {
			adm = admservice.search(id);
			if(adm != null) {
				if(adm.getAdmin_pwd().equals(pwd)) {
					if(adm.getAdmin_status()=='N') {
						return "login/loginadmfail";
					}	
					session.setAttribute("loginadm", adm);
					session.setAttribute("login_status", 'Y');

					return "redirect:/main";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login/loginfail";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "login/register";
	}
	
	@RequestMapping("/forgotpwd")
	public String forgotpwd() {
		return "forgot-password";
	}
}
	