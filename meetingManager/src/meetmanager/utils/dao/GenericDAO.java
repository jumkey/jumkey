package meetmanager.utils.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * 保存
	 * 
	 * @param instance
	 */
	public void save(T instance);

	/**
	 * 保存更新
	 * 
	 * @param instance
	 */
	public void saveOrUpdate(T instance);

	/**
	 * 更新
	 * 
	 * @param instance
	 */
	public void update(T instance);

	/**
	 * 删除
	 * 
	 * @param instance
	 */
	public void delete(T instance);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public T get(ID id);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 根据例子查询
	 * 
	 * @param instance
	 * @return
	 */
	public List<T> findByExample(T instance);

	/**
	 * 根据HQL语句进行update操作等
	 * 
	 * @param hql
	 * @return
	 */
	public int bulkUpdate(String hql);

	/**
	 * 根据HQL语句进行update操作等
	 * 
	 * @param hql
	 * @param value
	 * @return
	 */
	public int bulkUpdate(String hql, Object value);

	/**
	 * 根据HQL语句进行update操作等
	 * 
	 * @param hql
	 * @param value
	 * @return
	 */
	public int bulkUpdate(String hql, Object[] value);

	/**
	 * 根据HQL语句进行查询
	 * 
	 * @param queryString
	 * @return
	 */
	public List<T> find(String queryString);

	/**
	 * 根据HQL语句进行查询
	 * 
	 * @param queryString
	 * @param obj
	 * @return
	 */
	public List<T> find(String queryString, Object obj);

	/**
	 * 根据HQL语句进行查询
	 * 
	 * @param queryString
	 * @param obj
	 * @return
	 */
	public List<T> find(String queryString, Object[] obj);

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
	public List<T> findByNamedParam(String queryString, String paramName,
			Object value);

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
	public List<T> findByNamedParam(String queryString, String[] paramNames,
			Object[] values);

	/**
	 * 使用HIBERNATE映射文件中的定义的HQL语句进行查询
	 * 
	 * @param queryName
	 *            文件中定义的HQL语句的名字
	 * @return
	 */
	public List<T> findByNamedQuery(String queryName);

	/**
	 * 
	 * @param queryName
	 * @param value
	 * @return
	 */
	public List<T> findByNamedQuery(String queryName, Object value);

	/**
	 * 
	 * @param queryName
	 * @param values
	 * @return
	 */
	public List<T> findByNamedQuery(String queryName, Object[] values);

	/**
	 * 根据属性查询
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public List<T> findByProperty(String property, Object value);

	/**
	 * 分页查询 注:不能满足要求子类重写该方法
	 * 
	 * @param t
	 * @param firstResult
	 * @param maxResult
	 * @return 返回分页查询的数据
	 */
	public List<T> findByPagination(final T t, final int firstResult,
			final int maxResult);

	/**
	 * 分页查询 注:不能满足要求子类重写该方法
	 * 
	 * @param hsql
	 * @param page
	 * @return 返回分页查询的数据
	 */
	public List<T> findByPagination(final String hsql, final Page page);

	/**
	 * 分页统计查询
	 * 
	 * @param t
	 * @return 一共有多少条数据
	 */
	public int countByPagination(final T t);

	/**
	 * 查询记录总数
	 * 
	 * @param queryString
	 *            查询语句
	 * @return Integer 记录数
	 */
	public Integer getCountByQuery(final String queryString);
}