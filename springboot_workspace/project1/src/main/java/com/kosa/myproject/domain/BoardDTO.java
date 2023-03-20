package com.kosa.myproject.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SequenceGenerator(name="BOARD_SEQ_GENERATOR", sequenceName="SEQ_BOARD", initialValue=1, allocationSize=10)

@Entity
@Table(name="tb_board")
@Getter
@Setter
public class BoardDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_BOARD")
	private int seq;
	
	@Column(name="user_id", length=40, nullable=false)
	private String user_id;
	
	@Column(name="title", length=40, nullable=false)
	private String title;
	
	@Column(name="contents", nullable=false)
	private String contents;
	
	@Column(name="filename", length=100, nullable=false)
	private String filename;
	
	@Column(name="image_url", length=500, nullable=false)
	private String image_url;
	
	private LocalDateTime regdate = LocalDateTime.now();
	
	private LocalDateTime moddate = LocalDateTime.now();
	
	@Column(name="delyn1", length=2, nullable=false)
	private String delyn1;
	
	@Column(name="delyn2", length=2, nullable=false)
	private String delyn2;
	
	@Column(name="group_id", nullable=false)
	private int group_id;
	
	@Column(name="depth", nullable=false)
	private int depth;
	
	@Column(name="g_level", nullable=false)
	private int g_level;
	
	@Column(name="hit", length=10, nullable=false)
	private String hit;
	
}
