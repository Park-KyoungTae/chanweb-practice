package com.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RegularOrderDetail {
	private int regular_orderdetail_id;
	private int product_id;
	private int order_id;
	private int regular_price;	
}
