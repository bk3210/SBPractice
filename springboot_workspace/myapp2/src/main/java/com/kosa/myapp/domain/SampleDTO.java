package com.kosa.myapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SequenceGenerator(name="SEQ_GENERATOR", sequenceName="SEQ_SAMPLE", initialValue=1, allocationSize=1)
@Entity
@Table(name="tb_sample")
@Getter
@Setter
public class SampleDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
			generator="SEQ_GENERATOR")
	private int seq;
	private String test;
	
}
