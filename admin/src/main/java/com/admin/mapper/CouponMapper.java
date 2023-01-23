package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.Coupon;
import com.admin.frame.MyMapper;

@Mapper
@Repository
public interface CouponMapper extends MyMapper<Integer, Coupon>{
	public Coupon search(String id) throws Exception;
	public List<Coupon> getListByPaging(Criteria cri) throws Exception;
	public int getTotal(Criteria cri) throws Exception;
	public void changeStatus(int apr) throws Exception;

}