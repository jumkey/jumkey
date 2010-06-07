package xunbo.service;

import java.util.List;

import xunbo.pojo.Metas;

public interface IMetasService {
	public void addMetas(Metas metas);
	public List<Metas> getAllMetas();
	public List<Metas> getByProperty(String key, Object value);
}
