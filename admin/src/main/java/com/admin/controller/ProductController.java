package com.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.dto.Criteria;
import com.admin.dto.Page;
import com.admin.dto.Product;
import com.admin.service.ProductService;

@RequestMapping("/product")
@Controller
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	String dir ="list/";
	
	//페이징(일반,검색) 
	@GetMapping("/list")
	public String get(Model model, HttpSession session,
				@RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
				@RequestParam(value="amount", defaultValue="10") Integer amount,
				@RequestParam(value="option",defaultValue="") String option,
				@RequestParam(value="searchVal",defaultValue="") String searchVal
				) {
		if(session.getAttribute("option")!=null && session.getAttribute("searchVal")!=null) {
			option=(String)session.getAttribute("option");
			searchVal=(String)session.getAttribute("searchVal");
		
		}
		
		boolean isSearchOk = false;
		if(option.equals("") || searchVal.equals("")) {
			isSearchOk=true;
		}
		
		Criteria cri = new Criteria(pageNum,amount,option,searchVal,isSearchOk);
		
		int total=0;
		List<Product> products=null;
		
		try {
			products= productservice.getListByPaging(cri);
			total = productservice.getTotal(cri);
			
		} catch (Exception e) {
		}
		
		Page page = new Page(cri,total);
		
		model.addAttribute("product",products);
		model.addAttribute("pageMaker", page);
		session.removeAttribute("option");
		session.removeAttribute("searchVal");
		
		model.addAttribute("center",dir+"product");
		
		return "main";
	}
	
	// 
	@ResponseBody
	@RequestMapping("/searchlist")
	public String searchlist(String option, String searchVal,Model model, HttpSession session) {
		session.setAttribute("option",option);
		session.setAttribute("searchVal",searchVal);
		
		return "rediret:/product/list";
	}
	
	//삭제버튼
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(int del) {
		try {
			productservice.remove(del);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return "main";
	}
	
	@ResponseBody
	@RequestMapping("/changesale")
	public String changeSale(int product_id, int product_discount) {
		try {
			productservice.changeSale(product_id,product_discount);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return "list/product";
	}
	
	@RequestMapping("/popupmodify")
	public String popupModify() {
		return "popup/productmodify";
	}
	
	@ResponseBody
	@RequestMapping("/modify")
	public String modify(@RequestBody Product product) {
		try {
			productservice.modify(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "rediret:/product/popupmodify";
	}
	
	@RequestMapping("/popupsignUp")
	public String popupSignUp() {
		return "popup/productregister";
	}

	@ResponseBody
	@RequestMapping("/register")
	public String register(@RequestBody Product product) {
		try {
			productservice.register(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "rediret:/product/popupsignUp";
	}
}
