package xunbo.service.impl;

import java.util.List;

import com.google.appengine.api.datastore.Key;

import xunbo.dao.IContentsDAO;
import xunbo.pojo.Contents;
import xunbo.service.IContentsService;

public class ContentsServiceImpl implements IContentsService {
	private IContentsDAO contentsdao;
	public IContentsDAO getContentsdao() {
		return contentsdao;
	}

	public void setContentsdao(IContentsDAO contentsdao) {
		this.contentsdao = contentsdao;
	}

	public void addText(Contents contents) {
		contentsdao.saveEntity(contents);
	}

	public List<Contents> getAllText() {
		return contentsdao.getAllEntity();
	}

	public List<Contents> getAllPost() {
		return contentsdao.findByProperty("type", 1);
	}

	public Contents getTextByKey(Key id) {
		return contentsdao.getEntity(id);
	}

}
