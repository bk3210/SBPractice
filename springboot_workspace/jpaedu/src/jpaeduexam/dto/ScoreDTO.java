package jpaeduexam.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//오라클 시퀀스 - 이 어노테이션을 이용해 
//             오라클에  SEQ_SCORE라는 시퀀스가 만들어진다
//rdbms 중에서 오라클만 필요 다른 dbms는 필요없다
@SequenceGenerator(
		name="SCORE_SEQ_GENERATOR",
		sequenceName="SEQ_SCORE",
		initialValue=1,
		allocationSize=10
)

@Entity   //rdbms 테이블과 DTO객체를 연결한다 

@Table(name="TB_SCORE") //오라클에 TB_SCORE라는 Table을 생성 
public class ScoreDTO {
	@Id   //primary key로 사용한다 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, 
	generator="SEQ_SCORE") //자동생성, dbms마다 다르게 표시해야 한다 
	private int seq;
	
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime wdate;

	// getter/setter는 따로 적어야 함(Lombok이 없기 때문)
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}
	
	
}
