package org.cafeboy.dao;

import java.io.Serializable;
import java.util.List;

import org.cafeboy.model.Page;


public interface GenericDAO<T, ID extends Serializable> {

	// ����
	public void save(T instance);

	// ����
	public void update(T instance);

	// ɾ��
	public void delete(T instance);

	// ����ID��ѯ
	@SuppressWarnings("unchecked")
	public T get(ID id);

	// ��ѯ����
	@SuppressWarnings("unchecked")
	public List<T> findAll();

	// �������Ӳ�ѯ
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T instance);

	// ����HQL������update������
	public int bulkUpdate(String hql);

	// ����HQL������update������
	public int bulkUpdate(String hql, Object value);

	// ����HQL������update������
	public int bulkUpdate(String hql, Object[] value);

	// ����HQL�����в�ѯ
	@SuppressWarnings("unchecked")
	public List<T> find(String queryString);

	// ����HQL�����в�ѯ
	@SuppressWarnings("unchecked")
	public List<T> find(String queryString, Object obj);

	// ����HQL�����в�ѯ
	@SuppressWarnings("unchecked")
	public List<T> find(String queryString, Object[] obj);

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
			Object value);

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
			Object[] values);

	/**
	 * ʹ��HIBERNATEӳ���ļ��еĶ����HQL�����в�ѯ
	 * 
	 * @param queryName
	 *            �ļ��ж����HQL��������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName);

	/**
	 * 
	 * @param queryName
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName, Object value);

	/**
	 * 
	 * @param queryName
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName, Object[] values);

	/**
	 * �������Բ�ѯ
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String property, Object value);

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
			final int maxResult);

	/**
	 * ��ҳ��ѯ ע:��������Ҫ��������д�÷���
	 * 
	 * @param hsql
	 * @param page
	 * @return ���ط�ҳ��ѯ������
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByPagination(final String hsql, final Page page);

	/**
	 * ��ҳͳ�Ʋ�ѯ
	 * 
	 * @param t
	 * @return һ���ж���������
	 */
	@SuppressWarnings("unchecked")
	public int countByPagination(final T t);

	/**
	 * ��ѯ��¼����
	 * 
	 * @param queryString
	 *            ��ѯ���
	 * @return Integer ��¼��
	 */
	public Integer getCountByQuery(final String queryString);
}