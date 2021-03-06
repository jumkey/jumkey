package blog.pojo;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Article {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String title;

	@Persistent
	private String content;

	@Persistent
	private Date postDate;
	
	@Persistent(mappedBy = "article")
    private List<Comment> commentSets;

	public List<Comment> getCommentSets() {
		return commentSets;
	}

	public void setCommentSets(List<Comment> commentSets) {
		this.commentSets = commentSets;
	}

	public Article(String title, String content, Date postDate) {
		this.title = title;
		this.content = content;
		this.postDate = postDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}