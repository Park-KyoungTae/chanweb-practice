package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.OrderList;
import com.admin.frame.MyService;
import com.admin.mapper.OrderListMapper;

@Service
public class OrderListService implements MyService<Integer, OrderList>{

	@Autowired
	OrderListMapper olmapper;
	
	@Override
	public void register(OrderList v) throws Exception {
		olmapper.insert(v);
	}

	@Override
	public void modify(OrderList v) throws Exception {
		olmapper.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		olmapper.delete(k);
	}

	@Override
	public OrderList get(Integer k) throws Exception {
		return olmapper.select(k);
	}

	@Override
	public List<OrderList> getall() throws Exception {
		return olmapper.selectall();
	}
	
	//Paging
	public List<OrderList> getListByPaging(Criteria cri) throws Exception{
		return olmapper.getListByPaging(cri);
	};
	
	//COUNT
	public int getTotal(Criteria cri) throws Exception{
		return olmapper.getTotal(cri);
	}
	
	//배송상태변경
	public void changeState(OrderList ol) throws Exception{
		 olmapper.changeState(ol);
	}
}
