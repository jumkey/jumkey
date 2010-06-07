package xunbo.pojo;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Contents {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String title;
	@Persistent
	private String slug;
	@Persistent
	private String uri;
	@Persistent
	private Date created;
	@Persistent
	private Date modified;
	@Persistent(serialized = "true", defaultFetchGroup = "true")
	private Text text;
	@Persistent
	private List<Key> metas;
	@Persistent
	private Integer author;
	@Persistent
	private String template;
	@Persistent
	private Integer type;//1文章2评论
	@Persistent
	private String password;
	@Persistent
	private Integer commentsNum;
	@Persistent
	private Boolean allowComment;
	@Persistent
	private Boolean allowPing;
	@Persistent
	private Boolean allowFeed;
	@Persistent
	private List<Key> contents;

	public List<Key> getContents() {
		return contents;
	}

	public void setContents(List<Key> contents) {
		this.contents = contents;
	}
//	@Persistent
//	private Contents contents;
//	@Persistent(mappedBy = "contents")
//	private List<Contents> contentSets;
//
//	public Contents getContents() {
//		return contents;
//	}
//
//	public void setContents(Contents contents) {
//		this.contents = contents;
//	}
//
//	public List<Contents> getContentSets() {
//		return contentSets;
//	}
//
//	public void setContentSets(List<Contents> contentSets) {
//		this.contentSets = contentSets;
//	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public List<Key> getMetas() {
		return metas;
	}

	public void setMetas(List<Key> metas) {
		this.metas = metas;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCommentsNum() {
		return commentsNum;
	}

	public void setCommentsNum(Integer commentsNum) {
		this.commentsNum = commentsNum;
	}

	public Boolean getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(Boolean allowComment) {
		this.allowComment = allowComment;
	}

	public Boolean getAllowPing() {
		return allowPing;
	}

	public void setAllowPing(Boolean allowPing) {
		this.allowPing = allowPing;
	}

	public Boolean getAllowFeed() {
		return allowFeed;
	}

	public void setAllowFeed(Boolean allowFeed) {
		this.allowFeed = allowFeed;
	}

}
