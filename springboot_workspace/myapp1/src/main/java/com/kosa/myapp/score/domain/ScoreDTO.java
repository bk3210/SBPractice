package com.kosa.myapp.score.domain;

import com.kosa.myapp.common.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreDTO extends BaseDTO {
	private String seq="";
	private String name="";
	private int kor=0;
	private int mat=0;
	private int eng=0;
	private int total=0;
	private int avg=0;

}
