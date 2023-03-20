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

@Entity
@Table(name="tb_member2")
@Getter
@Setter
public class MemberDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GENERATOR")
	private int member_id;
	
	// 컬럼의 속성을 지정해주는 어노테이션(40byte, null값 허용x)
	// length 지정하지 않으면 255byte
	@Column(name="user_id", length=40, nullable=false)
	private String user_id;
	
	@Column(name="password", length=40, nullable=false)
	private String password;
	
	@Column(name="user_name", length=40, nullable=false)
	private String user_name;
	
	@Column(name="email", length=40, nullable=false)
	private String email;
	
	@Column(name="phone", length=40, nullable=false)
	private String phone;
	
	private LocalDateTime regdate = LocalDateTime.now();
	
	@Column(name="nickname", length=40, nullable=false)
	private String nickname;
	
	@Column(name="zipcode", length=40, nullable=false)
	private String zipcode;
	
	@Column(name="address1", length=100)
	private String address1;
	
	@Column(name="address2", length=100)
	private String address2;
	
	
}
