package com.sist.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
	
	int bookid;
	String bookname;
	String publisher;
	int price;
	
}
