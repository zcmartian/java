package com.marszhou.dao;

import java.util.List;
import com.marszhou.bean.Ibatis;;

public interface Dao {
	public List<Ibatis> getList();

	public Ibatis getByName(String name);

	public Ibatis getById(String id);

	public void insert(Ibatis ibatis);

	public void delete(String id);

	public void update(Ibatis ibatis);
}