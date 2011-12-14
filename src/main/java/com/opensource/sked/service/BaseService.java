package com.opensource.sked.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface BaseService<T> {

	public T findById(Long id);

	@Transactional(readOnly = false)
	public Long create(T domain);

	@Transactional(readOnly = false)
	public void save(T domain);

	public List<T> listAll();
}