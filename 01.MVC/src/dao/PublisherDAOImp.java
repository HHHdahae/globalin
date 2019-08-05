package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class PublisherDAOImp extends BaseDAO implements PublisherDAO {

	private static final String BOOK_SELECT_BY_PUBLISHER_SQL
	="select distinct publisher from book";

	@Override
	public List<Book> SelectByPublisher() {
		
		List<Book> bookList = new ArrayList<Book>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;	
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(BOOK_SELECT_BY_PUBLISHER_SQL);					
			resultSet = preparedStatement.executeQuery();	
			
			while(resultSet.next()) {
				Book book = new Book();
				
				book.setPublisher(resultSet.getString("publisher"));			
			
				bookList.add(book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);				
		}
		
		return bookList;		
		
	}
		
}
