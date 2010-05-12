package blog.service;

import java.util.List;

import javax.jdo.PersistenceManager;

import blog.db.PMF;
import blog.pojo.Article;
import blog.pojo.Metas;

public class ArticleServiceImpl implements ArticleService {

	public void create(Metas metas) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(metas);
		} finally {
			pm.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Metas> getMetas() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + Metas.class.getName();
		try {
			List<Metas> metas = (List<Metas>) pm.newQuery(query).execute();
			pm.detachCopyAll(metas);
			// articles.size();//Tell me why?
			return metas;
		} catch (Exception e) {
			return null;
		} finally {
			pm.close();
		}
	}

	public void create(Article article) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(article);
		} finally {
			pm.close();
		}
	}

	public Article retrieve(String id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Article article = pm.getObjectById(Article.class, id);
			pm.detachCopy(article);
			return article;
		} catch (Exception e) {
			return null;
		} finally {
			pm.close();
		}
	}

	public void update(Article article) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Article original = pm.getObjectById(Article.class, article.getId());
			original.setContent(article.getContent());
			original.setPostDate(article.getPostDate());
			original.setTitle(article.getTitle());
			pm.makePersistent(original);
		} finally {
			pm.close();
		}
	}

	public void delete(String id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Article article = pm.getObjectById(Article.class, id);
			pm.deletePersistent(article);
		} finally {
			pm.close();
		}
	}
}
