package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.Cust;
import com.shop.frame.MyMapper;

@Mapper
@Repository
public interface CustMapper extends MyMapper<String, Cust>{

}
