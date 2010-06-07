package xunbo.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<E, ID extends Serializable> {

	/**
	 * 根据主键获得实体
	 * 
	 * @param id
	 *            实体主键
	 * @return BaseEntity
	 */
	E getEntity(ID id);

	/**
	 * 获得所有实体
	 * 
	 * @return List
	 */
	List<E> getAllEntity();

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            pojo instance
	 */
	void saveEntity(E entity);

	/**
	 * 根据主键删除实体
	 * 
	 * @param id
	 *            实体主键
	 */
	void removeEntity(ID id);

	List<E> findByProperty(String key, Object value);

	void flush();
}
