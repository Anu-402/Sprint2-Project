package com.capg.hcms.test_management.model;

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
@Table(name="test")
public class TestManagement {

	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="testmanagement_seq",allocationSize=1)
	@Column(name="testid")
	private int testId;
	
	@Column(name="testname",length=20)
	private String testName;
	
	public TestManagement(int testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}

	public TestManagement() {
		super();
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

	
}
