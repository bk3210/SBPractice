package com.kosa.myapp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access=AccessLevel.PUBLIC)	// 기본 생성자
public class BoardDTO {
	private String seq="";
	private String title="";
	private String writer="";
	private String contents="";
	private String filename="";
	private String image_url="";

	@Builder	// 생성자 오버로딩
	public BoardDTO(String seq, String title, String writer, String contents, String filename, String image_url) {
		super();
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.filename = filename;
		this.image_url = image_url;
	}

}
