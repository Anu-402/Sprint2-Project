package com.cg.hcs.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="center_tbl")
public class Center {

	  @Id
	  @GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	  @SequenceGenerator(name="mygen",sequenceName="center_seq",allocationSize=1)
	  @Column(name="centerid")
	  private int centerId;
	  
	  @Column(name="centername",length=20)
	  private String centerName;
	  
	  @Column(name="centerlocation",length=20)
	  private String centerLocation;
	  
	  @Column(name="centeraddress")
	  private String centerAddress;
	  
	  @OneToMany(mappedBy="center")
	  @JsonIgnore
	  List<HealthTest>  tests = new ArrayList<>();

	public Center(int centerId, String centerName, String centerLocation, String centerAddress,
			List<HealthTest> tests) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.centerLocation = centerLocation;
		this.centerAddress = centerAddress;
		this.tests = tests;
	}

	public Center() {
		super();
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterLocation() {
		return centerLocation;
	}

	public void setCenterLocation(String centerLocation) {
		this.centerLocation = centerLocation;
	}

	public String getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

	public List<HealthTest> getTests() {
		return tests;
	}

	public void setTests(List<HealthTest> tests) {
		this.tests = tests;
	}

	

	}
	

