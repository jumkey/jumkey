package xunbo.action;

import java.util.List;

import xunbo.pojo.Contents;
import xunbo.pojo.Metas;
import xunbo.service.IContentsService;
import xunbo.service.IMetasService;

import com.google.appengine.api.datastore.Key;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class IndexAction extends ActionSupport{
	private IContentsService contentsservice;
	private IMetasService metasservice;

	public IMetasService getMetasservice() {
		return metasservice;
	}

	public void setMetasservice(IMetasService metasservice) {
		this.metasservice = metasservice;
	}

	public IContentsService getContentsservice() {
		return contentsservice;
	}

	public void setContentsservice(IContentsService contentsservice) {
		this.contentsservice = contentsservice;
	}
	public String execute(){
		contents=contentsservice.getAllText();
		metas=metasservice.getAllMetas();
		return "success";
	}
	public String show(){
		content=contentsservice.getTextByKey(key);
		metas=metasservice.getAllMetas();
		return "show";
	}
	public String add(){
		metas=metasservice.getAllMetas();
		return "add";
	}
	private List<Contents> contents;
	private List<Metas> metas;
	private Key key;
	private Contents content;

	public Contents getContent() {
		return content;
	}

	public void setContent(Contents content) {
		this.content = content;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public List<Metas> getMetas() {
		return metas;
	}

	public void setMetas(List<Metas> metas) {
		this.metas = metas;
	}

	public List<Contents> getContents() {
		return contents;
	}

	public void setContents(List<Contents> contents) {
		this.contents = contents;
	}
}
