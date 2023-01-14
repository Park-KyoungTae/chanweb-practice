package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Admin;
import com.admin.frame.MyService;
import com.admin.mapper.AdminMapper;

@Service
public class AdminService implements MyService<Integer, Admin>{

	@Autowired
	AdminMapper admmapper;
	
	@Override
	public void register(Admin v) throws Exception {
		admmapper.insert(v);
	}

	@Override
	public void modify(Admin v) throws Exception {
		admmapper.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		admmapper.delete(k);
	}

	@Override
	public Admin get(Integer k) throws Exception {
		return admmapper.select(k);
	}

	@Override
	public List<Admin> getall() throws Exception {
		return admmapper.selectall();
	}
}
