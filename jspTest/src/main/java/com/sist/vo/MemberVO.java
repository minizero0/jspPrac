package com.sist.vo;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data						//게터,세터,투 스트링 등등
@AllArgsConstructor			//매개변수를 갖는 생성자 
@NoArgsConstructor			//매개변수 없는 생성자
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
}
