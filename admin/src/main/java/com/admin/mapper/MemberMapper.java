package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.Member;
import com.admin.frame.MyMapper;

@Mapper
@Repository
public interface MemberMapper extends MyMapper<Integer, Member>{
	public Member search(String id) throws Exception;
	public List<Member> getListByPaging(Criteria cri) throws Exception;
	public int getTotal(Criteria cri) throws Exception;
	public void changeStatus(int apr) throws Exception;

}