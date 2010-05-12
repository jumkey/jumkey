package blog.service;

import blog.pojo.Article;
import blog.pojo.Metas;

public interface ArticleService {
	public void create(Metas metas);

	public void create(Article article);

	public Article retrieve(String id);

	public void update(Article article);

	public void delete(String id);
}
