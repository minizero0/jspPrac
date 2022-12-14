package com.sist.vo;

import java.sql.Date;

import lombok.Data;


@Data
public class BoardVO {
	private int no;
	private String Writer;
	private String pwd;
	private String title;
	private String content;
	private Date regdate;
	private int hit;
	private String fname;
	private int b_ref;
	private int b_step;
	private int b_level;
}
