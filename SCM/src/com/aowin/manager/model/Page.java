package com.aowin.manager.model;

public class Page {
	private int pageSize;//每页条数
	private int totalPage;//总页数
	private int currentPage; //当前第几页
	private int totalNum;//总记录数
	public Page() {
		this.pageSize=5;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		int num=totalNum/pageSize;
		if(totalNum%pageSize==0) {
			return (int)Math.floor(totalNum/pageSize);
		}else {
			return (int)Math.floor(totalNum/pageSize)+1;
		}
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
}
