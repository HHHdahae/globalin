package service;

import dao.PageDAO;
import dao.PageDAOImp;
import page.PageGroupResult;
import page.PageInfo;
import page.PageRowResult;

public class PageManager {
	
	private int requestPage;
	
	public PageManager() {}
		
	public PageManager(int requestPage) {
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();		
		//PageRowResult의 객체변수 값 세팅
				 
		pageRowResult.setRowStartNumber(PageInfo.ROW_COUNT_PRE_PAGE*requestPage-(PageInfo.ROW_COUNT_PRE_PAGE-1));
		//다른 방법 pageRowResult.setRowStartNumber(PageInfo.ROW_COUNT_PRE_PAGE*(requestPage-1)+1);		
		
		pageRowResult.setRowEndNumber(PageInfo.ROW_COUNT_PRE_PAGE*requestPage);
			
		return pageRowResult;
	}
	public PageGroupResult getPageGroupResult(String sql) {
		
		PageGroupResult pageGroupResult = new PageGroupResult();
		//PageGroupResult의 객체 변수 값 세팅
		//int requestPageGroupNumber = (requestPage-1)/ PageInfo.SHOW_PAGE_COUNT ;0번 그룹부터
		int requestPageGroupNumber = (int)Math.ceil((double)requestPage/PageInfo.SHOW_PAGE_COUNT);
	
		pageGroupResult.setGroupStartNumber(1+(PageInfo.SHOW_PAGE_COUNT*(requestPageGroupNumber-1)));
		pageGroupResult.setGroupEndNumber(requestPageGroupNumber*PageInfo.SHOW_PAGE_COUNT);
		
		PageDAO pd = new PageDAOImp();
		int totalRow = pd.getCount(sql);
		
		//c총줄수 / 한페이지에 보여주는 줄 수 
		int totalPageNumber = (int)Math.ceil((double)totalRow/PageInfo.ROW_COUNT_PRE_PAGE);
		
		//마지막 페이지 링크값 변경하기
		if(pageGroupResult.getGroupEndNumber() > totalPageNumber) {
			pageGroupResult.setGroupEndNumber(totalPageNumber);			
		}
		
		
		//before, after 유무
		if(pageGroupResult.getGroupStartNumber()==1) {
			
			pageGroupResult.setBeforPage(false);
			
		}
		if(pageGroupResult.getGroupEndNumber()==totalPageNumber) {
			
			pageGroupResult.setAfterPage(false);
		}
		
		pageGroupResult.setSelectPageNumber(requestPage);
		
				
		return pageGroupResult;
	}
	
/*	public static void main(String[] args) {
				
		System.out.println();
		
	}*/
	
	
}
