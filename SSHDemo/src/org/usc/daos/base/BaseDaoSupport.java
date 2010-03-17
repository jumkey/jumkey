package org.usc.daos.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.usc.beans.base.QueryResult;
import org.usc.utils.base.GenericsUtils;

/**
 * DAO层封装使用了泛型，包含常用的CURD和分页操作
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-3-9<br>
 *        Revision of last commit:$Revision: 648 $<br>
 *        Author of last commit:$Author: nhjsjmz@gmail.com $<br>
 *        Date of last commit:$Date: 2010-03-09 19:52:10 +0800 (周二, 09 三月 2010) $<br>
 *        <p>
 */
@SuppressWarnings("unchecked")
public abstract class BaseDaoSupport<T> extends HibernateDaoSupport implements IBaseDao<T>
{
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	protected String entityClassName = getEntityName(this.entityClass);

	/*
	 * @see org.usc.daos.DAO#findByEntity(java.lang.Object)
	 */
	public List<T> findByEntity(Object entiey)
	{
		return super.getHibernateTemplate().findByExample(entiey);
	}

	/*
	 * @see org.usc.daos.DAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List<T> findByProperty(String propertyName, Object value)
	{
		String queryString = "from " + entityClassName + " o where o." + propertyName + "= ?";
		return super.getHibernateTemplate().find(queryString, value);
	}

	/*
	 * @see org.usc.daos.DAO#delete(java.io.Serializable[])
	 */
	public void delete(Serializable... entityids)
	{
		for (Object id : entityids)
		{
			super.getHibernateTemplate().delete(find((Serializable) id));
		}
	}

	/*
	 * @see org.usc.daos.DAO#find(java.io.Serializable)
	 */
	public T find(Serializable entityId)
	{
		if (null != entityId)
			return (T) super.getHibernateTemplate().get(entityClass, entityId);
		return null;
	}

	public void save(Object entity)
	{
		super.getHibernateTemplate().save(entity);
	}

	/*
	 * @see org.usc.daos.DAO#update(java.lang.Object)
	 */
	public void update(Object entity)
	{
		super.getHibernateTemplate().update(entity);
	}

	/*
	 * @see org.usc.daos.DAO#getScrollData(int, int, java.lang.String, java.lang.Object[], java.util.LinkedHashMap)
	 */
	public QueryResult<T> getScrollData(final int firstindex, final int maxresult, final String wherejpql, final Object[] queryParams,
			final LinkedHashMap<String, String> orderby)
	{
		final QueryResult<T> queryResult = new QueryResult<T>();

		super.getHibernateTemplate().execute(new HibernateCallback<T>()
		{
			public T doInHibernate(Session session) throws HibernateException, SQLException
			{
				String hql = "from " + entityClassName + " o " + (wherejpql == null || "".equals(wherejpql.trim()) ? "" : " where " + wherejpql)
						+ buildOrderby(orderby);
				Query query = session.createQuery(hql);
				setQueryParams(query, queryParams);// where
				queryResult.setTotalRecord(query.list().size());// first get size

				if (firstindex != -1 && maxresult != -1)
					query.setFirstResult(firstindex).setMaxResults(maxresult);// last page

				queryResult.setResultList(query.list());

				return null;
			}

		});

		return queryResult;

	}

	/*
	 * @see org.usc.daos.DAO#getScrollData(int, int, java.lang.String, java.lang.Object[])
	 */
	public QueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams)
	{
		return getScrollData(firstindex, maxresult, wherejpql, queryParams, null);
	}

	/*
	 * @see org.usc.daos.DAO#getScrollData(int, int, java.util.LinkedHashMap)
	 */
	public QueryResult<T> getScrollData(final int firstindex, final int maxresult, final LinkedHashMap<String, String> orderby)
	{
		return getScrollData(firstindex, maxresult, null, null, orderby);

	}

	/*
	 * @see org.usc.daos.DAO#getScrollData(int, int)
	 */
	public QueryResult<T> getScrollData(final int firstindex, final int maxresult)
	{
		return getScrollData(firstindex, maxresult, null, null, null);
	}

	/*
	 * @see org.usc.daos.DAO#getScrollData()
	 */
	public QueryResult<T> getScrollData()
	{
		return getScrollData(-1, -1, null, null, null);
	}

	/*
	 * @see org.usc.daos.DAO#save(java.lang.Object)
	 */

	/**
	 * 获取实体的名称
	 * 
	 * @param <E>
	 * @param clazz
	 *            实体类
	 * @return
	 */
	protected static <E> String getEntityName(Class<E> clazz)
	{
		String entityname = clazz.getSimpleName();
		return entityname;
	}

	/**
	 * 设置HQL里边的属性值
	 * 
	 * @param query
	 * @param queryParams
	 */
	protected static void setQueryParams(Query query, Object[] queryParams)
	{
		if (queryParams != null && queryParams.length > 0)
		{
			for (int i = 0; i < queryParams.length; i++)
			{
				query.setParameter(i, queryParams[i]);// 从0开始
			}
		}
	}

	/**
	 * 组装order by语句
	 * 
	 * @param orderby
	 * @return
	 */
	protected static String buildOrderby(LinkedHashMap<String, String> orderby)
	{
		StringBuffer orderbyql = new StringBuffer("");
		if (orderby != null && orderby.size() > 0)
		{
			orderbyql.append(" order by ");
			for (String key : orderby.keySet())
			{
				orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
			}
			orderbyql.deleteCharAt(orderbyql.length() - 1);
		}
		return orderbyql.toString();
	}
}
