package com.aowin.manager.model;

public class Page {
	private int pageSize;//ÿҳ����
	private int totalPage;//��ҳ��
	private int currentPage; //��ǰ�ڼ�ҳ
	private int totalNum;//�ܼ�¼��
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
