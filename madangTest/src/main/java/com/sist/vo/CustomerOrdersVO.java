package com.sist.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class CustomerOrdersVO {
	private String bookname;
	private int price;
	private Date orderDate;
}
