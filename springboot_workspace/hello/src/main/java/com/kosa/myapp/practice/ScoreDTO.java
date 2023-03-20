package com.kosa.myapp.practice;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access=AccessLevel.PUBLIC)	// 기본 생성자
// 메소드 매개변수, argument, parameter라고도 부른다
// 접근권한이 public타입인 기본생성자를 만들라는 어노테이션
public class ScoreDTO {
	private String name="";
	private int kor=0;
	private int mat=0;
	private int eng=0;
	private int total=0;
	private int avg=0;
}
