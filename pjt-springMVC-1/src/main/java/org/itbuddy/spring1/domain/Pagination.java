package org.itbuddy.spring1.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Pagination {

	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	private PageRequest pageRequest;


	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	public void calcData() {
		// 마지막 페이지 = 소숫점 아래 버림(소숫점 아래 반올림( n / 10)*10)
		endPage =(int)(Math.ceil(pageRequest.getPage() / (double) displayPageNum) * displayPageNum);
		// 시작 페이지 = (마지막 페이지 - n)+1
		startPage = (endPage - displayPageNum)+1;
		// 임시 마지막 페이지 = 소숫점 아래 버림(소숫점 아래 반올림( n / 페이지별 크기))
		int tempEndPage = (int)(Math.ceil(totalCount / (double) pageRequest.getSizePerPage()));
		
		// 마지막 페이지 > 임시 마지막 페이지 -> 마지막 페이지 = 임시 마지막 페이지
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		// 이전 페이지  == 1 ? 없음 : 있음
		prev = startPage == 1 ? false : true;
		//다음 페이지  == 마지막 페이지 * 페이지별 크기 ? 없음 : 있음
		// 전체 데이터 수 >=  마지막 페이지수 * 페이지 별 크기 ? 없음 : 있음 
		next = endPage * pageRequest.getSizePerPage() >= totalCount ? false : true;
		
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public PageRequest getPageRequest() {
		return pageRequest;
	}
	
	public String makeQuery(int page) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum",pageRequest.getSizePerPage()).build();
		
	
		return uriComponents.toUriString();
	}
	
	
}
