package com.opensource.sked.service.impl;

import java.util.List;

import com.opensource.sked.dao.BaseDao;
import com.opensource.sked.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	protected abstract BaseDao<T> getDao();

	public Long create(T domain) {
		return getDao().create(domain);
	}

	public T findById(Long id) {
		return getDao().findById(id);
	}

	public List<T> listAll() {
		return getDao().listAll();
	}

	public void save(T domain) {
		getDao().save(domain);
	}

}