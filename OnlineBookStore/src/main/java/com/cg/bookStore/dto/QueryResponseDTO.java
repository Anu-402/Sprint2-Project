package com.cg.bookStore.dto;

import java.util.List;

import com.cg.bookStore.entity.CustomerInformation;

public class QueryResponseDTO {

	 private List<CustomerInformation> list;
	 private long totalNoOfPages;
	 private int currentPageNumber;
	public List<CustomerInformation> getList() {
		return list;
	}
	public void setList(List<CustomerInformation> list) {
		this.list = list;
	}
	public long getTotalNoOfPages() {
		return totalNoOfPages;
	}
	public void setTotalNoOfPages(long totalNoOfPages) {
		this.totalNoOfPages = totalNoOfPages;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	 
	
	 
}