package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PublisherDAO;
import dao.PublisherDAOImp;
import model.Book;

@WebServlet (name="BookController", urlPatterns= {"/input_publisher"})

public class BookController extends HttpServlet{

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
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		req.setCharacterEncoding("utf-8"); 
		
		if(action.equals("input_publisher")) {			
			
			PublisherDAO d = new PublisherDAOImp();
			
			List<Book> booklist = d.SelectByPublisher();	
			System.out.println(booklist);
			
			req.setAttribute("booklist", booklist);
			
			RequestDispatcher rd =req.getRequestDispatcher("/jsp/input/publisherForm.jsp");
			rd.forward(req, resp);
		}	
		
	}	
}
