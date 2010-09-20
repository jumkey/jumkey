package com.onegrid.meetmanager.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class GenericDAOHibernate<T, ID extends Serializable> extends
		HibernateDaoSupport implements GenericDAO<T, ID> {
	protected Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOHibernate() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * 根据主键获得实体
	 * 
	 * @param id
	 *            实体主键
	 * @return 实体对象
	 */
	@SuppressWarnings("unchecked")
	public final T getEntity(final ID id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 获得所有实体
	 * 
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public final List<T> getAllEntity() {
		List<T> l = getHibernateTemplate().loadAll(clazz);
		return l;
	}

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体对象
	 */
	public final void saveEntity(final T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
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
			getHibernateTemplate().delete(o);
		}
	}

	/**
	 * 执行批量更新和删除操作的HQL
	 * 
	 * @param sql
	 *            hql语句
	 * @return PageList
	 */
	@SuppressWarnings("unchecked")
	protected final List<T> executeHQL(final String sql) {
		Session session = null;
		List<T> ret = null;
		try {
			session = this.getSession();
			if (sql.toUpperCase().startsWith("DELETE")
					|| sql.toUpperCase().startsWith("UPDATE")) {
				session.createQuery(sql).executeUpdate();
			} else {
				ret = session.createQuery(sql).list();
			}
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		} finally {
			this.releaseSession(session);
		}
		return ret;
	}

	/**
	 * 计算HQL查询的返回记录数
	 * 
	 * @param sql
	 *            查询语句
	 * @param countField
	 *            count语句操作的字段
	 * @return 记录数
	 */
	protected int countHQL(String sql, String countField) {

		int rowsCount = 0;
		Session session = null;
		try {
			session = this.getSession();
			if (null == countField) {
				countField = "*";
			}
			sql = "select count(" + countField + ") " + sql;
			rowsCount = ((Integer) session.createQuery(sql).iterate().next())
					.intValue();
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		} finally {
			this.releaseSession(session);
		}
		return rowsCount;
	}

	/**
	 * 计算HQL查询的返回记录数
	 * 
	 * @param sql
	 *            查询语句
	 * @return 记录数
	 */
	protected int countHQL(String sql) {
		return countHQL(sql, null);
	}
}
