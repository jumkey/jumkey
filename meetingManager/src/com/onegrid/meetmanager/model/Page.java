package com.onegrid.meetmanager.model;

public class Page implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private static Integer DEFAULT_PAGE_SIZE = 30;
	private Integer id;
	private Integer start = 0; // 记录的起始行
	private Integer end = 1; // 记录的结束行
	private Integer pageCount = 0; // 总页数
	private Integer recordCount = 0; // 总记录数
	private Integer currentPage = 1; // 当前页
	private Integer pageSize = DEFAULT_PAGE_SIZE; // 单页条数

	public Page(Integer currentPage, Integer recordCount, Integer pageSize) {
		if (currentPage < 1)
			currentPage = 1;
		this.currentPage = currentPage;
		if (pageSize < 1)
			pageSize = 1;
		this.pageSize = pageSize;
		setRecordCount(recordCount);
		start += (currentPage - 1) * pageSize;
		end = start + pageSize;
	}

	public Page(Integer currentPage, Integer recordCount) {
		this(currentPage, recordCount, DEFAULT_PAGE_SIZE);
	}

	public Page() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount() {
		pageCount = recordCount / pageSize
				+ (recordCount % pageSize == 0 ? 0 : 1);
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
		setPageCount();
		end = (end <= recordCount ? end : recordCount + 1);
		currentPage = (currentPage <= pageCount ? currentPage : pageCount);
	}

	public boolean getHasPrevious() {
		return currentPage > 1;
	}

	public boolean getHasNext() {
		return currentPage < pageCount;
	}

}