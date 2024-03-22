package com.nagarro.Mini_Assignment_2.dtos;

public class PageInfo {

	private boolean hasNextPage;
	private boolean hasPreviousPage;
	private long total;

	public PageInfo() {
	}

	public PageInfo(boolean hasNextPage, boolean hasPreviousPage, long total) {
		super();
		this.hasNextPage = hasNextPage;
		this.hasPreviousPage = hasPreviousPage;
		this.total = total;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageInfo [hasNextPage=" + hasNextPage + ", hasPreviousPage=" + hasPreviousPage + ", total=" + total
				+ ", isHasNextPage()=" + isHasNextPage() + ", isHasPreviousPage()=" + isHasPreviousPage()
				+ ", getTotal()=" + getTotal() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
