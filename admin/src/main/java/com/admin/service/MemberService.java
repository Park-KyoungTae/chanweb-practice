package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.Member;
import com.admin.frame.MyService;
import com.admin.mapper.MemberMapper;

@Service
public class MemberService implements MyService<Integer, Member>{

	@Autowired
	MemberMapper memmapper;
	
	@Override
	public void register(Member v) throws Exception {
		memmapper.insert(v);
	}

	@Override
	public void modify(Member v) throws Exception {
		memmapper.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		memmapper.delete(k);
	}

	@Override
	public Member get(Integer k) throws Exception {
		return memmapper.select(k);
	}

	@Override
	public List<Member> getall() throws Exception {
		return memmapper.selectall();
	}
	
	//SearchID
	public Member search(String id) throws Exception{
		return memmapper.search(id);
	}
	
	//Paging
	public List<Member> getListByPaging(Criteria cri) throws Exception{
		return memmapper.getListByPaging(cri);
	};
	
	//COUNT
	public int getTotal(Criteria cri) throws Exception{
		return memmapper.getTotal(cri);
	}
	
	//changeStatus
	public void changeStatus(int apr) throws Exception{
		memmapper.changeStatus(apr);
	}
	
}
