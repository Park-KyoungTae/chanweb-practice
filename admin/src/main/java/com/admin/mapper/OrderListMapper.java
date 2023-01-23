package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.OrderList;
import com.admin.frame.MyMapper;

@Mapper
@Repository
public interface OrderListMapper extends MyMapper<Integer, OrderList>{
	public List<OrderList> getListByPaging(Criteria cri) throws Exception;
	public int getTotal(Criteria cri) throws Exception;

}