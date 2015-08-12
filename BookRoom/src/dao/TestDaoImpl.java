package dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;



import domain.Test;

public class TestDaoImpl implements TestDao {
	private static SqlMapClient sqlMap;
	void init() {
	    try {
	      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	      sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
	      reader.close(); 
	    } catch (IOException e) {
	      // Fail fast.
	      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
	    }
	  }
	
	public List queryTest() {
		// TODO Auto-generated method stub
		List list = null;
		this.init();
		 try {
			 list= sqlMap.queryForList("getAllTest");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
		
	}

	public boolean deleteTest(String id) {
		this.init();
		try {
			sqlMap.delete("deleteTestById",id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

		
	}

	public boolean insertTest(Test t) {
		this.init();
		try {
			sqlMap.insert("insertTest",t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		// TODO Auto-generated method stub
	}


	public boolean updateTest(Test t) {
		this.init();
		try {
			sqlMap.update("updateTest",t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;
		
	}

	public List queryTestName(String name) {
		// TODO Auto-generated method stub
		this.init();
		List list = null;
		 try {
			 list= sqlMap.queryForList("selectTestByUsername",name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}

}
