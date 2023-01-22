package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.AdminPost;
import com.admin.frame.MyService;
import com.admin.mapper.AdminpostMapper;

@Service
public class AdminpostService implements MyService<Integer, AdminPost>{

	@Autowired
	AdminpostMapper admpostmapper;
	
	@Override
	public void register(AdminPost v) throws Exception {
		admpostmapper.insert(v);
	}

	@Override
	public void modify(AdminPost v) throws Exception {
		admpostmapper.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		admpostmapper.delete(k);
	}

	@Override
	public AdminPost get(Integer k) throws Exception {
		return admpostmapper.select(k);
	}

	@Override
	public List<AdminPost> getall() throws Exception {
		return admpostmapper.selectall();
	}
	
	//Paging
	public List<AdminPost> getListByPaging(Criteria cri) throws Exception{
		return admpostmapper.getListByPaging(cri);
	};
	
	//COUNT
	public int getTotal(Criteria cri) throws Exception{
		return admpostmapper.getTotal(cri);
	}
	
}
