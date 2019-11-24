package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@SuppressWarnings("unused")
public abstract class GenericDAOImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {
	@Produces
	@PersistenceContext(unitName = "XYZ-PU")
	protected EntityManager entityManager;

	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" }) // This just removes some warnings
	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public T findById(Id id) {
		T entity = (T) entityManager.find(type, id);
		return entity;
	}

	public void delete(Id id) {
		T entity = (T) entityManager.getReference(type, id);
		entityManager.remove(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	public abstract List<T> findAll();

	public void deleteAll() {
		List<T> entityList = findAll();
		for (T entity : entityList) {
			delete(entity);
		}
	}

}