package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.Category;
import com.admin.frame.MyService;
import com.admin.mapper.CategoryMapper;

@Service
public class CategoryService implements MyService<Integer, Category>{

	@Autowired
	CategoryMapper catemapper;
	
	@Override
	public void register(Category v) throws Exception {
		catemapper.insert(v);
	}

	@Override
	public void modify(Category v) throws Exception {
		catemapper.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		catemapper.delete(k);
	}

	@Override
	public Category get(Integer k) throws Exception {
		return catemapper.select(k);
	}

	@Override
	public List<Category> getall() throws Exception {
		return catemapper.selectall();
	}
	
	//SearchTitle
	public Category search(String title) throws Exception{
		return catemapper.search(title);
	}
	
	//Paging
	public List<Category> getListByPaging(Criteria cri) throws Exception{
		return catemapper.getListByPaging(cri);
	};
	
	//COUNT
	public int getTotal(Criteria cri) throws Exception{
		return catemapper.getTotal(cri);
	}
	

	
}
