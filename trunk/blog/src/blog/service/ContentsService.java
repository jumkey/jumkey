package blog.service;

import java.util.List;

import blog.pojo.Contents;

import com.google.appengine.api.datastore.Text;

public interface ContentsService {
	public void addText(String title,String slug,String uri,Text text,String tags,int meta);
	public List<Contents> getAllText();
}
