package dao;

import java.util.List;

import model.Book;

public interface PublisherDAO {
	
	List<Book> SelectByPublisher();	
}
