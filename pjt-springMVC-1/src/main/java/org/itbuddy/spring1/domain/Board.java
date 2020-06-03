package org.itbuddy.spring1.domain;

import java.io.Serializable;
import java.sql.Date;


public class Board implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8345786174220971024L;
	
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	
	
	private PageRequest pageRequest;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}


	// 페이징 요펑 멤버변수를 사용하여 페이징 정보를 반환한다.
	public int getPage() {
		return pageRequest.getPage();
	}
	
	public int getSizePerPage() {
		return pageRequest.getSizePerPage();
	}
	
	//페이징 요청 멤버변수의 Getter/Setter 메서드를 정의한다.
	public PageRequest getPageRequest() {
		return pageRequest;
	}
	
	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate +"]";
	}
	
	
	
	
	
	
	

}
