package com.onegrid.meetmanager.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class GenericDAOHibernate<T, ID extends Serializable> extends
		HibernateDaoSupport implements GenericDAO<T, ID> {
	protected Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOHibernate() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	// 保存
	public void save(T instance) {
		getHibernateTemplate().save(instance);
	}

	// 更新
	public void update(T instance) {
		getHibernateTemplate().update(instance);
	}

	// 删除
	public void delete(T instance) {
		getHibernateTemplate().delete(instance);
	}

	// 根据ID查询
	@SuppressWarnings("unchecked")
	public T get(ID id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	// 查询所有
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getHibernateTemplate().loadAll(clazz);
	}

	// 根据例子查询
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T instance) {
		return getHibernateTemplate().findByExample(instance);
	}

	// 根据HQL语句进行update操作等
	public int bulkUpdate(String hql) {
		return getHibernateTemplate().bulkUpdate(hql);
	}

	// 根据HQL语句进行update操作等
	public int bulkUpdate(String hql, Object value) {
		return getHibernateTemplate().bulkUpdate(hql, value);
	}

	// 根据HQL语句进行update操作等
	public int bulkUpdate(String hql, Object[] value) {
		return getHibernateTemplate().bulkUpdate(hql, value);
	}

	// 根据HQL语句进行查询
	@SuppressWarnings("unchecked")
	public List<T> find(String queryString) {
		return getHibernateTemplate().find(queryString);
	}

	// 根据HQL语句进行查询
	@SuppressWarnings("unchecked")
	public List<T> find(String queryString, Object obj) {

		return getHibernateTemplate().find(queryString, obj);
	}

	// 根据HQL语句进行查询
	@SuppressWarnings("unchecked")
	public List<T> find(String queryString, Object[] obj) {
		return getHibernateTemplate().find(queryString, obj);
	}

	/**
	 * 使用命名查询进行查询
	 * 
	 * @param queryString
	 *            HQL
	 * @param paramName
	 *            参数名
	 * @param value
	 *            参数值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedParam(String queryString, String paramName,
			Object value) {
		return this.getHibernateTemplate().findByNamedParam(queryString,
				paramName, value);
	}

	/**
	 * 使用命名查询进行查询 多个参数
	 * 
	 * @param queryString
	 *            HQL
	 * @param paramNames
	 *            参数名的数组
	 * @param values
	 *            参数值的数组
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		return this.getHibernateTemplate().findByNamedParam(queryString,
				paramNames, values);
	}

	/**
	 * 使用HIBERNATE映射文件中的定义的HQL语句进行查询
	 * 
	 * @param queryName
	 *            文件中定义的HQL语句的名字
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName) {
		return getHibernateTemplate().findByNamedQuery(queryName);
	}

	/**
	 * 
	 * @param queryName
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName, Object value) {
		return getHibernateTemplate().findByNamedQuery(queryName, value);
	}

	/**
	 * 
	 * @param queryName
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName, Object[] values) {
		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	/**
	 * 根据属性查询
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String property, Object value) {
		return this.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(clazz).add(
						Restrictions.eq(property, value)));
	}

	/**
	 * 分页查询 注:不能满足要求子类重写该方法
	 * 
	 * @param t
	 * @param firstResult
	 * @param maxResult
	 * @return 返回分页查询的数据
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByPagination(final T t, final int firstResult,
			final int maxResult) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(clazz);
				criteria.add(Example.create(t).enableLike(MatchMode.ANYWHERE));
				criteria.setFirstResult(firstResult);
				criteria.setMaxResults(maxResult);
				return criteria.list();
			}
		});
	}

	/**
	 * 分页统计查询
	 * 
	 * @param t
	 * @return 一共有多少条数据
	 */
	@SuppressWarnings("unchecked")
	public int countByPagination(final T t) {
		return (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(clazz);
						criteria.setProjection(Projections.rowCount());
						criteria.add(Example.create(t).enableLike(
								MatchMode.ANYWHERE));
						return criteria.uniqueResult();
					}
				});
	}
}
