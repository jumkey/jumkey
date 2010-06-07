package xunbo.action;

import java.util.List;

import xunbo.pojo.Metas;
import xunbo.service.IMetasService;

public class MetasAction {

	private IMetasService metasservice;

	public IMetasService getMetasservice() {
		return metasservice;
	}

	public void setMetasservice(IMetasService metasservice) {
		this.metasservice = metasservice;
	}

	public String add() {
		metasservice.addMetas(meta);
		// metas=metasservice.getByProperty("name", "11");
		metas = metasservice.getAllMetas();
		return "success";
	}

	private Metas meta;
	private List<Metas> metas;

	public Metas getMeta() {
		return meta;
	}

	public void setMeta(Metas meta) {
		this.meta = meta;
	}

	public List<Metas> getMetas() {
		return metas;
	}

	public void setMetas(List<Metas> metas) {
		this.metas = metas;
	}
}
