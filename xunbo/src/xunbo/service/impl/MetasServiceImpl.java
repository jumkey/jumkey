package xunbo.service.impl;

import java.util.List;

import xunbo.dao.IMetasDAO;
import xunbo.pojo.Metas;
import xunbo.service.IMetasService;

public class MetasServiceImpl implements IMetasService {
	private IMetasDAO metasdao;

	public IMetasDAO getMetasdao() {
		return metasdao;
	}

	public void setMetasdao(IMetasDAO metasdao) {
		this.metasdao = metasdao;
	}

	public void addMetas(Metas metas) {
		metasdao.saveEntity(metas);
	}
	public List<Metas> getByProperty(String key, Object value) {
		return metasdao.findByProperty(key,value);
	}
	public List<Metas> getAllMetas() {
		return metasdao.getAllEntity();
	}
}
