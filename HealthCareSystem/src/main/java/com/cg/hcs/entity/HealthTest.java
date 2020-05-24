package com.cg.hcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="test_tbl")
public class HealthTest {

	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="test_seq",allocationSize=1)
	@Column(name="testid")
	private int testId;
	
	@Column(name="testname",length=20)
	private String testName;
	
	@ManyToOne
	@JoinColumn(name="centerid")
	private Center center;
    
	
	
	public HealthTest(int testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}

	public int getTestId() {
		return testId;
	}
    
	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	
	
}
