package blog.service;

import java.util.List;

import com.google.appengine.api.datastore.Text;

import blog.DAO.ContentsDAO;
import blog.DAO.ContentsDAOImpl;
import blog.pojo.Contents;

public class ContentsServiceImpl implements ContentsService {

	public void addText(String title,String slug,String uri,Text text,String tags,int meta) {
		ContentsDAO contentsdao=new ContentsDAOImpl();
		Contents contents=new Contents();
		contents.setTitle(title);
		contents.setSlug(slug);
		contents.setUri(uri);
		contents.setText(text);
		contents.setTags(tags);
		contents.setMeta(meta);
		contentsdao.create(contents);
	}

	public List<Contents> getAllText() {
		ContentsDAO contentsdao=new ContentsDAOImpl();
		return contentsdao.getAllContents();
	}

}
