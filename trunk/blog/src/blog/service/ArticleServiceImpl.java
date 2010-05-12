package blog.service;

import javax.jdo.PersistenceManager;

import blog.db.PMF;
import blog.pojo.Article;

public class ArticleServiceImpl implements ArticleService {
	protected ArticleServiceImpl() {
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
