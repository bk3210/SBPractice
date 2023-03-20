package address;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(
		name="ADDRESS_SEQ_GENERATOR",	// 시퀀스 제너레이터 이름
		sequenceName="SEQ_ADDRESS",		// 시퀀스 이름
		initialValue=1,		// 시작값
		allocationSize=1	// 할당할 메모리 범위값
		)

@Entity
@Table(name="address")	// Address라는 이름의 table 생성
public class AddressDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ADDRESS")
	private int seq;
	
	private String name;
	private String phone;
	private String email;
	
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime wdate;
	
	public AddressDTO() {
	}
	
	public AddressDTO(int seq) {
		this.seq = seq;
		this.name = "";
		this.phone = "";
		this.email = "";
	}
	
	

	@Override
	public String toString() {
		return String.format("%d %s %s %s %s", seq, name, phone, email, wdate);
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}
	
	
}
