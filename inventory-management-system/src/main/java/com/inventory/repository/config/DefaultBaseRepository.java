package com.inventory.repository.config;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
 
@Repository
public abstract class DefaultBaseRepository<T> extends RepositoryConfig<T> implements BaseRepository<T>{

	@PersistenceContext(unitName = "entityManagerFactory")
	@Override
	public void setEntityManager(EntityManager entityManager){
		super.setEntityManager(entityManager);
	}
 
	@Override
	public T add(T entity) {
		 getEntityManager().persist(entity);
		 return entity;
	}

	@Override
	public boolean delete(T entity) {
		if(!getEntityManager().contains(entity)) {
			return false;
		}
		getEntityManager().remove(entity);
		return true;
	}

	@Override
	public T edit(T entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public T findById(int id) {
		return getEntityManager().find(getDefaultEntityPath().getType(), id);
	}
	
	@Override
	public List<T>  findAll() {
		return getJpaQueryFactory().selectFrom(getDefaultEntityPath()).fetch();
	}

}
