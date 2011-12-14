package com.opensource.sked.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensource.sked.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	public Long create(T domain) {
		return (Long) getHibernateTemplate().save(domain);
	}

	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		return (T) getHibernateTemplate().get(getEntityClass(), id);
	}

    protected Class<?> getEntityClass() {
		return null;
	}

	public void save(T domain) {
		getHibernateTemplate().saveOrUpdate(domain);
	}

	@SuppressWarnings("unchecked")
	public List<T> listAll() {
		return getHibernateTemplate().find(
				"from " + getEntityClass().getSimpleName());
	}

}