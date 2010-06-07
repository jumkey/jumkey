package xunbo.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.jdo.support.JdoDaoSupport;

import xunbo.dao.IGenericDAO;

public abstract class GenericDAOJdo<E, ID extends Serializable> extends
		JdoDaoSupport implements IGenericDAO<E, ID> {

	protected final Log log = LogFactory.getLog(this.getClass().getName());
	protected Class<E> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOJdo() {
		this.clazz = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * 根据主键获得实体
	 * 
	 * @param id
	 *            实体主键
	 * @return 实体对象
	 */
	@SuppressWarnings("unchecked")
	public final E getEntity(final ID id) {
		return (E) getJdoTemplate().getObjectById(clazz, id);
	}

	/**
	 * 获得所有实体
	 * 
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public final List<E> getAllEntity() {
		List<E> result = (List<E>) getJdoTemplate().find(clazz);
		return result;
	}

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体对象
	 */
	public final void saveEntity(final E entity) {
		getJdoTemplate().makePersistent(entity);
	}

	/**
	 * 根据主键删除实体
	 * 
	 * @param id
	 *            实体主键
	 */
	public final void removeEntity(final ID id) {
		Object o = getEntity(id);
		if (null != o) {
			getJdoTemplate().deletePersistent(o);
		}
	}

	@SuppressWarnings("unchecked")
	public final List<E> findByProperty(String key, Object value) {
		String sql="select from " + clazz.getName()+" where "+key+"=='"+value+"'";
		return (List<E>) getJdoTemplate().find(sql);
	}

	public final void flush() {
		getJdoTemplate().flush();
	}

}
