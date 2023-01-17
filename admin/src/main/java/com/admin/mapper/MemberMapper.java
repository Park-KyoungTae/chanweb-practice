package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Member;
import com.admin.frame.MyMapper;

@Mapper
@Repository
public interface MemberMapper extends MyMapper<Integer, Member>{
	public Member search(String id) throws Exception;
}
