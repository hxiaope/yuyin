package com.yuyin.common.pojo;

import java.util.List;

/**
 * 
 * @Title:EUDataGridResult
 * @author hxiaope
 * @date 2016年10月24日下午5:13:05
 * @version 1.0
 */
public class PageResult {
	
	private long total;//总共多少条数据
	private long pageSize;//多少页
	private long pageRow;//一页显示多少条
	private long pageNum;//当前页
	private long offset;//用于显示第offset条
	private long endOffset;//到endoffset条数据
	private List<?> rows;//保存数据
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	}
	public long getEndOffset() {
		return endOffset;
	}
	public void setEndOffset(long endOffset) {
		this.endOffset = endOffset;
	}
	public long getPageNum() {
		return pageNum;
	}
	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}
	public long getPageRow() {
		return pageRow;
	}
	public void setPageRow(long pageRow) {
		this.pageRow = pageRow;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
