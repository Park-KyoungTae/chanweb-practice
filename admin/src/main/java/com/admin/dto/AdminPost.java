package com.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdminPost {
	private int adminpost_id;
	private int admin_index;
	private String post_type;
	private String post_subject;
	private String post_content;
	private String post_attach1;
	private String post_attach2;
	private Date register_date;
}
