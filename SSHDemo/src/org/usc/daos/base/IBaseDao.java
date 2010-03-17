package org.usc.daos.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.usc.beans.base.QueryResult;

/**
 * DAO层封装接口，包含常用的CURD和分页操作
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-3-9<br>
 *        Revision of last commit:$Revision: 648 $<br>
 *        Author of last commit:$Author: nhjsjmz@gmail.com $<br>
 *        Date of last commit:$Date: 2010-03-09 19:52:10 +0800 (周二, 09 三月 2010) $<br>
 *        <p>
 */
public interface IBaseDao<T>
{

	/**
	 * 根据属性查找对象
	 * 
	 * @param propertyName
	 *            属性（对应Bean）
	 * @param value
	 *            属性
	 * @return 根据属性查找对象
	 */
	public List<T> findByProperty(String propertyName, Object value);

	/**
	 * 根据实体查找对象
	 * 
	 * @param entiey
	 *            实体（T类型）
	 * @return 根据属性查找对象
	 */
	public List<T> findByEntity(Object entiey);

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            实体id
	 */
	public void save(Object entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 *            实体id
	 */
	public void update(Object entity);

	/**
	 * 删除实体
	 * 
	 * @param entityClass
	 *            实体类
	 * @param entityids
	 *            实体id数组
	 */
	public void delete(Serializable... entityids);

	/**
	 * 获取实体
	 * 
	 * @param <T>
	 * @param entityClass
	 *            实体类
	 * @param entityId
	 *            实体id
	 * @return
	 */
	public T find(Serializable entityId);

	/**
	 * 获取分页数据
	 * 
	 * @param firstindex
	 *            开始索引
	 * @param maxresult
	 *            每页显示记录数
	 * @param wherejpql
	 *            where语句
	 * @param queryParams
	 *            查询参数
	 * @param orderby
	 *            排序序列
	 * @return 分页数据
	 */
	public QueryResult<T> getScrollData(final int firstindex, final int maxresult, final String wherejpql, final Object[] queryParams,
			final LinkedHashMap<String, String> orderby);

	/**
	 * 获取分页数据
	 * 
	 * @param firstindex
	 *            开始索引
	 * @param maxresult
	 *            每页显示记录数
	 * @param wherejpql
	 *            where语句
	 * @param queryParams
	 *            查询参数
	 * @return 分页数据
	 */
	public QueryResult<T> getScrollData(final int firstindex, final int maxresult, final String wherejpql, final Object[] queryParams);

	/**
	 * 获取分页数据
	 * 
	 * @param firstindex
	 *            开始索引
	 * @param maxresult
	 *            每页显示记录数
	 * @param orderby
	 *            排序序列
	 * @return 分页数据
	 */
	public QueryResult<T> getScrollData(final int firstindex, final int maxresult, final LinkedHashMap<String, String> orderby);

	/**
	 * 获取分页数据
	 * 
	 * @param firstindex
	 *            开始索引
	 * @param maxresult
	 *            每页显示记录数
	 * @return 分页数据
	 */
	public QueryResult<T> getScrollData(final int firstindex, final int maxresult);

	/**
	 * 获取所有对象
	 * 
	 * @return 所有对象
	 */
	public QueryResult<T> getScrollData();
}
