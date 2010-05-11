package blog.DAO;

import java.util.List;

import javax.jdo.PersistenceManager;

import blog.db.PMF;
import blog.pojo.Article;

public class ArticleDAO {
	public void addArticle(Article article) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(article);
		} finally {
			pm.close();
		}
	}

	public Article getArticle(Long id) {
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

	@SuppressWarnings("unchecked")
	public List<Article> getArticles() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + Article.class.getName();
		try {
			List<Article> articles = (List<Article>) pm.newQuery(query).execute();
			pm.detachCopyAll(articles);
			// articles.size();//Tell me why?
			return articles;
		} catch (Exception e) {
			return null;
		} finally {
			pm.close();
		}
	}
}
