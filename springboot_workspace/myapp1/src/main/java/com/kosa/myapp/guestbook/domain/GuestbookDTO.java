package com.kosa.myapp.guestbook.domain;

import com.kosa.myapp.common.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestbookDTO extends BaseDTO {
	private String seq="";
	private String title="";
	private String writer="";
	private String contents="";
	private String wdate="";
	private String hit="";
	
}
