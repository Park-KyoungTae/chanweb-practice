package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.Item;
import com.shop.frame.ImgUtil;
import com.shop.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@Value("${custdir}")
	String custdir;
	
	String dir = "item/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"center");
		return "main";
	}
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"add");
		return "main";
	}
	@RequestMapping("/register")
	public String register(Model model, Item item) {
		
		// name, price, imgname
		String name = item.getName();
		int price = item.getPrice();
		String imgname = item.getImg().getOriginalFilename();
		
		item.setImgname(imgname);
		try {
			ImgUtil.saveFile(item.getImg(), custdir);
			service.register(item);
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
		List<Item> list = null;
		try {
			list = service.get();
			model.addAttribute("plist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"getall");
		return "main";
	}
	
	@RequestMapping("/get")
	public String get(Model model, int id) {
		Item obj = null;
		try {
			obj = service.get(id);
			model.addAttribute("obj", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"get");
		return "main";
	}
	
	@RequestMapping("/update")
	public String update(Model model, Item item) {
		String imgname = item.getImg().getOriginalFilename();
		if(imgname.equals("") || imgname == null) {
			try {
				service.modify(item);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			String uimgname = item.getImg().getOriginalFilename();
			item.setImgname(uimgname);
			try {
				service.modify(item);
				ImgUtil.saveFile(item.getImg(), custdir);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:get?id="+item.getId();
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, int id) {
		try {
			service.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:getall";
	}
}











