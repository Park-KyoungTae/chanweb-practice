package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Admin;
import com.admin.dto.Criteria;
import com.admin.frame.MyMapper;

@Mapper
@Repository
public interface AdminMapper extends MyMapper<Integer, Admin>{
	public Admin search(String id) throws Exception;
	public List<Admin> getListByPaging(Criteria cri) throws Exception;
	public int getTotal(Criteria cri) throws Exception;
	public void changeStatus(int apr) throws Exception;

}