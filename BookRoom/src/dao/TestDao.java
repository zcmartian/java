package dao;

import java.util.List;

import domain.Test;


public interface TestDao {
	public boolean insertTest(Test t);
	public boolean deleteTest(String id);
	public boolean updateTest(Test t);
	public List queryTest();
	public List queryTestName(String name);
}
