package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.AdminPost;
import com.admin.frame.MyMapper;

@Mapper
@Repository
public interface AdminpostMapper extends MyMapper<Integer, AdminPost>{
	public List<AdminPost> getListByPaging(Criteria cri) throws Exception;
	public int getTotal(Criteria cri) throws Exception;
}