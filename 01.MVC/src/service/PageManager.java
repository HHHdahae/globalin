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
		//PageRowResult�� ��ü���� �� ����
				 
		pageRowResult.setRowStartNumber(PageInfo.ROW_COUNT_PRE_PAGE*requestPage-(PageInfo.ROW_COUNT_PRE_PAGE-1));
		//�ٸ� ��� pageRowResult.setRowStartNumber(PageInfo.ROW_COUNT_PRE_PAGE*(requestPage-1)+1);		
		
		pageRowResult.setRowEndNumber(PageInfo.ROW_COUNT_PRE_PAGE*requestPage);
			
		return pageRowResult;
	}
	public PageGroupResult getPageGroupResult(String sql) {
		
		PageGroupResult pageGroupResult = new PageGroupResult();
		//PageGroupResult�� ��ü ���� �� ����
		//int requestPageGroupNumber = (requestPage-1)/ PageInfo.SHOW_PAGE_COUNT ;0�� �׷����
		int requestPageGroupNumber = (int)Math.ceil((double)requestPage/PageInfo.SHOW_PAGE_COUNT);
	
		pageGroupResult.setGroupStartNumber(1+(PageInfo.SHOW_PAGE_COUNT*(requestPageGroupNumber-1)));
		pageGroupResult.setGroupEndNumber(requestPageGroupNumber*PageInfo.SHOW_PAGE_COUNT);
		
		PageDAO pd = new PageDAOImp();
		int totalRow = pd.getCount(sql);
		
		//c���ټ� / ���������� �����ִ� �� �� 
		int totalPageNumber = (int)Math.ceil((double)totalRow/PageInfo.ROW_COUNT_PRE_PAGE);
		
		//������ ������ ��ũ�� �����ϱ�
		if(pageGroupResult.getGroupEndNumber() > totalPageNumber) {
			pageGroupResult.setGroupEndNumber(totalPageNumber);			
		}
		
		
		//before, after ����
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
