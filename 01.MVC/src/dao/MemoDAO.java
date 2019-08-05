package dao;

import java.util.List;

import model.Memo;

public interface MemoDAO {
	
	List<Memo> selectAll();
	List<Memo> selectAll(int rowStartNumber, int rowEndNumber);
	
	List<Memo> selectByName(String name);
	Memo SelectByMemoId(int Memoid);
		
	boolean insert (Memo memo);
	boolean update (Memo memo);
	boolean deleteByMemoId(int Memoid);	
	
	
	
}
