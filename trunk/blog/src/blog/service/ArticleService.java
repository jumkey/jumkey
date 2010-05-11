package blog.service;

import blog.pojo.Article;

public interface ArticleService {
	public void create(Article article);

	public Article retrieve(String id);

	public void update(Article article);

	public void delete(String id);
}
