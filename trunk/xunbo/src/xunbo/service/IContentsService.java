package xunbo.service;

import java.util.List;

import com.google.appengine.api.datastore.Key;

import xunbo.pojo.Contents;

public interface IContentsService {
	public void addText(Contents contents);
	public List<Contents> getAllText();
	public List<Contents> getAllPost();
	public Contents getTextByKey(Key id);
}
