package com.onegrid.meetmanager.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

    /**
     * 根据主键获得实体
     * 
     * @param id 实体主键
     * @return BaseEntity
     */
    T getEntity(ID id);

    /**
     * 获得所有实体
     * 
     * @return List
     */
    List<T> getAllEntity();

    /**
     * 保存实体
     * 
     * @param entity pojo instance
     */
    void saveEntity(T entity);

    /**
     * 根据主键删除实体
     * 
     * @param id 实体主键
     */
    void removeEntity(ID id);
}