package com.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.Member;
import com.admin.service.MemberService;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	@Autowired
	MemberService memservice;
	
	String dir ="list/";
	
	@RequestMapping("/list")
	public String get(Model model, HttpSession session) {
		String status =null;
		List<Member> member =null;
		try {
			status = (String) session.getAttribute("login_status");
			if(status!="Y" || status==null){
				return "redirect:/login";
			}
			member= memservice.getall();
		} catch (Exception e) {
			//e.printStackTrace();
		}	
		model.addAttribute("member",member);
		model.addAttribute("center",dir+"member");
		return "main";
	}
}
	