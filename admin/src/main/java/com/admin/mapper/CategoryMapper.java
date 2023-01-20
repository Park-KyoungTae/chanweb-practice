package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.Category;
import com.admin.frame.MyMapper;

@Mapper
@Repository
public interface CategoryMapper extends MyMapper<Integer, Category>{
	public Category search(String title) throws Exception;
	public List<Category> getListByPaging(Criteria cri) throws Exception;
	public int getTotal(Criteria cri) throws Exception;

}