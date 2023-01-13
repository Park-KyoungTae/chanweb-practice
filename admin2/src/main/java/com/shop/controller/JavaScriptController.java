package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/javascript")
public class JavaScriptController {

	String dir = "javascript/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"center");
		return "main";
	}
	@RequestMapping("/ch1")
	public String ch1(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch1");
		return "main";
	}
	
	@RequestMapping("/ch2")
	public String ch2(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch2");
		
		model.addAttribute("mytxt", "Welcome My Site");
		return "main";
	}
	
	@RequestMapping("/ch3")
	public String ch3(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch3");
		return "main";
	}
	
	@RequestMapping("/ch4")
	public String ch4(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch4");
		return "main";
	}
	
	@RequestMapping("/ch5")
	public String ch5(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch5");
		return "main";
	}
	
	@RequestMapping("/ch6")
	public String ch6(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch6");
		return "main";
	}
	
	@RequestMapping("/ch7")
	public String ch7(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch7");
		return "main";
	}
	
	@RequestMapping("/ch8")
	public String ch8(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch8");
		return "main";
	}
	
	@RequestMapping("/ch9")
	public String ch9(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch9");
		return "main";
	}
	
}


