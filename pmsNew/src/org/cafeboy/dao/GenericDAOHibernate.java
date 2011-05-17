package org.cafeboy.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.cafeboy.model.Page;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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

	// ����
	public void save(T instance) {
		getHibernateTemplate().save(instance);
	}

    // �������
    public void saveOrUpdate(T instance) {
        getHibernateTemplate().saveOrUpdate(instance);
    }

	// ����
	public void update(T instance) {
		getHibernateTemplate().update(instance);
	}

	// ɾ��
	public void delete(T instance) {
		getHibernateTemplate().delete(instance);
	}

	// ����ID��ѯ
	@SuppressWarnings("unchecked")
	public T get(ID id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	// ��ѯ����
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getHibernateTemplate().loadAll(clazz);
	}

	// �������Ӳ�ѯ
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T instance) {
		return getHibernateTemplate().findByExample(instance);
	}

	// ����HQL������update������
	public int bulkUpdate(String hql) {
		return getHibernateTemplate().bulkUpdate(hql);
	}

	// ����HQL������update������
	public int bulkUpdate(String hql, Object value) {
		return getHibernateTemplate().bulkUpdate(hql, value);
	}

	// ����HQL������update������
	public int bulkUpdate(String hql, Object[] value) {
		return getHibernateTemplate().bulkUpdate(hql, value);
	}

	// ����HQL�����в�ѯ
	@SuppressWarnings("unchecked")
	public List<T> find(String queryString) {
		return getHibernateTemplate().find(queryString);
	}

	// ����HQL�����в�ѯ
	@SuppressWarnings("unchecked")
	public List<T> find(String queryString, Object obj) {

		return getHibernateTemplate().find(queryString, obj);
	}

	// ����HQL�����в�ѯ
	@SuppressWarnings("unchecked")
	public List<T> find(String queryString, Object[] obj) {
		return getHibernateTemplate().find(queryString, obj);
	}

	/**
	 * ʹ��������ѯ���в�ѯ
	 * 
	 * @param queryString
	 *            HQL
	 * @param paramName
	 *            ������
	 * @param value
	 *            ����ֵ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedParam(String queryString, String paramName,
			Object value) {
		return this.getHibernateTemplate().findByNamedParam(queryString,
				paramName, value);
	}

	/**
	 * ʹ��������ѯ���в�ѯ �������
	 * 
	 * @param queryString
	 *            HQL
	 * @param paramNames
	 *            ������������
	 * @param values
	 *            ����ֵ������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		return this.getHibernateTemplate().findByNamedParam(queryString,
				paramNames, values);
	}

	/**
	 * ʹ��HIBERNATEӳ���ļ��еĶ����HQL�����в�ѯ
	 * 
	 * @param queryName
	 *            �ļ��ж����HQL��������
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
	 * �������Բ�ѯ
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
	 * ��ҳ��ѯ ע:��������Ҫ��������д�÷���
	 * 
	 * @param t
	 * @param firstResult
	 * @param maxResult
	 * @return ���ط�ҳ��ѯ������
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
	 * ��ҳ��ѯ ע:��������Ҫ��������д�÷���
	 * 
	 * @param hsql
	 * @param page
	 * @return ���ط�ҳ��ѯ������
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByPagination(final String hsql, final Page page) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hsql);
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getMaxResult());
				List<T> list = query.list();
				if(list==null||list.size()==0){
					page.setSelectRows(0);
				}else{
					page.setSelectRows(list.size());
				}
				return list;
			}
		});
	}

	/**
	 * ��ҳͳ�Ʋ�ѯ
	 * 
	 * @param t
	 * @return һ���ж���������
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

	/**
	 * ��ѯ��¼����
	 * 
	 * @param queryString
	 *            ��ѯ���
	 * @return Integer ��¼��
	 */
	public Integer getCountByQuery(final String queryString){
		int rowsCount = 0;
		rowsCount = ((Integer) getSession().createQuery("select count(*) " + queryString).iterate().next()).intValue();
		return rowsCount; 
	}
}
