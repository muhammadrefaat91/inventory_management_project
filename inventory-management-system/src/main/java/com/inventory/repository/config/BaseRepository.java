package com.inventory.repository.config;

import java.util.List;

public interface BaseRepository<T> {

	/**
	 * add new entity
	 * 
	 * @param entity
	 * @return 
	 */
	T add(T object);
	
	/** delete entity by id
	 * 
	 * @param id
	 */
	boolean delete(T t);
	
	/**
	 * edit entity info by id
	 * 
	 * @param id 
	 */
	T edit(T t);
	

	/**  find entity by id
	 * @param id
	 * @return
	 */
	T findById(int id);
	
	/**  find entity by id
	 * @param id
	 * @return
	 */
	List<T> findAll();
	

}
