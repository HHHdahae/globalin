package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemoDAO;
import dao.MemoDAOImp;
import model.Memo;
import page.PageSQL;
import service.PageManager;


@WebServlet(name="MomoController", urlPatterns= {"/memo_input","/memo_save","/memo_list",
							"/memo_detail","/memo_update","/memo_delete","/memo_search","/memo_req_list"})
public class MomoController extends HttpServlet{
	
	private static final Integer Intger = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);				
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);				
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		System.out.println(uri);
		
		req.setCharacterEncoding("utf-8");
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);	
		
		
		if(action.equals("memo_input")) {
			
			RequestDispatcher rd =req.getRequestDispatcher("/jsp/memo/memoForm.jsp");
			rd.forward(req, resp);
			
		}else if (action.equals("memo_save")) {
		
			req.setCharacterEncoding("utf-8");//ÇÑ±Û ±úÁü ¹æÁö 
			
			MemoDAO dao = new MemoDAOImp();
			Memo memo = new Memo();
			
			memo.setName(req.getParameter("name"));
			memo.setAge(Integer.parseInt(req.getParameter("age")));			
			
			boolean result = dao.insert(memo);		
			System.out.println(result);
			
			RequestDispatcher rd =req.getRequestDispatcher("/jsp/memo/memoForm.jsp");
			rd.forward(req, resp);
								
		}else if(action.equals("memo_list")) {

			MemoDAO dao = new MemoDAOImp();

			List<Memo> memoList = dao.selectAll();
			
			req.setAttribute("memos",memoList);
			
			for (Memo m:memoList) {
				System.out.println(m);
			}
									
			RequestDispatcher rd =req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);			
			
		}else if(action.equals("memo_detail")) {
			
			int memoid = Integer.parseInt(req.getParameter("memoid"));
			MemoDAO dao = new MemoDAOImp();
			Memo memo =dao.SelectByMemoId(memoid);
			
			req.setAttribute("memo", memo);
			
			RequestDispatcher rd =req.getRequestDispatcher("/jsp/memo/memoDetail.jsp");
			rd.forward(req, resp);	
			
		}else if(action.equals("memo_update")) {
			
			req.setCharacterEncoding("utf-8");
						
			Memo memo = new Memo();
			
			memo.setMemoid(Integer.parseInt(req.getParameter("memoid")));
			memo.setName(req.getParameter("name"));
			memo.setAge(Integer.parseInt(req.getParameter("age")));			
			
			MemoDAO dao = new MemoDAOImp();
			boolean result = dao.update(memo);	
			
			System.out.println(result);
	
			resp.sendRedirect("/memo_list");
		
		}else if (action.equals("memo_delete")){
			req.setCharacterEncoding("utf-8");
			
			int memoid = Integer.parseInt(req.getParameter("memoid"));
					
			MemoDAO dao = new MemoDAOImp();
			boolean result = dao.deleteByMemoId(memoid);
			
			resp.sendRedirect("/memo_req_list");
		
		}else if (action.equals("memo_search")) {
			
			String name =req.getParameter("name");
			
			MemoDAO dao = new MemoDAOImp();
			List <Memo> memoList =dao.selectByName(name);
			
			req.setAttribute("memos", memoList);
			
			RequestDispatcher rd =req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);	
			
		}else if (action.equals("memo_req_list")) {
			
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			PageManager pm = new PageManager(requestPage);
			
			MemoDAO dao = new MemoDAOImp();
			List<Memo> memos =  dao.selectAll(pm.getPageRowResult().getRowStartNumber(), pm.getPageRowResult().getRowEndNumber());
			
			req.setAttribute("memos", memos);
			req.setAttribute("pageGroupResult", pm.getPageGroupResult(PageSQL.MEMO_SELECT_ALL_COUNT));
							
			RequestDispatcher rd =req.getRequestDispatcher("/jsp/memo/memoList.jsp");
			rd.forward(req, resp);	
		}
	
	}
			
}