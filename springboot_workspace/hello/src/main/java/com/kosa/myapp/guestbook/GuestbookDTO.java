package com.kosa.myapp.guestbook;

import lombok.Getter;
import lombok.Setter;

// getter/setter를 대체하는 어노테이션
// 이 기능을 지원하는 것이 lombok
@Getter
@Setter 
public class GuestbookDTO {
	private String id="";
	private String title="";
	private String writer="";
	private String contents="";
	private String wdate="";

	
}
