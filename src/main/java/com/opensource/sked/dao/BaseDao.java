package com.opensource.sked.dao;

import java.util.List;

public interface BaseDao<T> {

	public T findById(Long id);

	public Long create(T domain);

	public void save(T domain);

	public List<T> listAll();
}