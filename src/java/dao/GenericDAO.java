package dao;

import java.io.Serializable;
import java.util.List;
/*
* @author nik_3
*/

public interface GenericDAO<T, Id extends Serializable> {

	public void persist(T entity);

	public void update(T entity);

	public T findById(Id id);

	public void delete(Id id);

	public void delete(T entity);

	public List<T> findAll();

	public void deleteAll();

}