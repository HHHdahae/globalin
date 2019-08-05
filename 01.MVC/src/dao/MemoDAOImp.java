package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Memo;

public class MemoDAOImp extends BaseDAO implements MemoDAO {

	private static final String MEMO_INSET_SQL
	="insert into memo VALUES(seq_memo.nextval,?,?)";
	
	private static final String MEMO_SELECT_ALL_SQL
	="select memoid,name,age from memo order by memoid desc";
	
	private static final String MEMO_SELECT_BY_MEMOID_SQL
	="select memoid,name,age from memo where memoid=?";
	
	private static final String MEMO_UPDATE_SQL
	="update memo SET name=?,age=? where memoid=?";
	
	private static final String MEMO_DELETE_SQL
	="delete memo where memoid=?";
	
	private static final String MEMO_SELECT_BY_NAME_SQL
	="select memoid,name,age from memo where name like ? order by memoid desc";
	
	private static final String MEMO_SELECT_FOR_PAGE_SQL
	="select * from(select rownum rn,memos.* from (select * from memo order by memoid desc) memos) where rn between ? and ?";
	
	
	@Override
	public boolean insert(Memo memo) {
		boolean result = false;
		
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection=getConnection();
			preparedStatement =connection.prepareStatement(MEMO_INSET_SQL);
			
			preparedStatement.setString(1,memo.getName() );
			preparedStatement.setInt(2,memo.getAge());
							
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {
				result = true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(null, preparedStatement, connection);
		}

		return result;
	}

	@Override
	public List<Memo> selectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		
		List<Memo> memoList = new ArrayList<Memo>();
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next()) {
				Memo memo = new Memo();				
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));
				memo.setMemoid(resultSet.getInt("memoid"));
					
				memoList.add(memo);
			}	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);		
		
		}
		return memoList;
	}

	@Override
	public Memo SelectByMemoId(int Memoid) {
		Memo memo = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = getConnection();
			preparedStatement =connection.prepareStatement(MEMO_SELECT_BY_MEMOID_SQL);
			preparedStatement.setInt(1,Memoid);
			resultSet = preparedStatement.executeQuery();
			
			 if(resultSet.next()) {
				memo = new Memo();
				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));			
			}
						
		} catch (SQLException e) {			
			e.printStackTrace();			
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return memo;		
	}

	@Override
	public boolean update(Memo memo) {
		boolean result = false;
		
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_UPDATE_SQL);
			preparedStatement.setString(1,memo.getName());	
			preparedStatement.setInt(2,memo.getAge());	
			preparedStatement.setInt(3,memo.getMemoid());	
										
			int rowCount = preparedStatement.executeUpdate();
				
			if(rowCount>0) {
					result = true;
			}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeDBObjects(null, preparedStatement, connection);
			}

			return result;
	}

	@Override
	public boolean deleteByMemoId(int Memoid) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;		
	
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_DELETE_SQL);

			preparedStatement.setInt(1, Memoid);
			preparedStatement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			closeDBObjects(null, preparedStatement, connection);				
		}
		return result;
	}

	@Override
	public List<Memo> selectByName(String name) {
		
		List<Memo> memoList = new ArrayList<Memo>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;	
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_BY_NAME_SQL);			
		
			preparedStatement.setString(1,'%'+name+'%');
			
			resultSet = preparedStatement.executeQuery();	
			
			while(resultSet.next()) {
				Memo memo = new Memo();
				
				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));
			
				memoList.add(memo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);				
		}
		
		return memoList;		
		
	}

	@Override
	public List<Memo> selectAll(int rowStartNumber, int rowEndNumber) {
		List<Memo> memoList = new ArrayList<Memo>();
		
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_FOR_PAGE_SQL);
			preparedStatement.setInt(1,rowStartNumber);
			preparedStatement.setInt(2,rowEndNumber);
			resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next()) {
				Memo memo = new Memo();				
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));
				memo.setMemoid(resultSet.getInt("memoid"));
					
				memoList.add(memo);
			}	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);		
		
		}
		return memoList;
	}
}
