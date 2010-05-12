package blog.pojo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Contents {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long cid;// int(10) 主键,非负,自增 post表主键
	@Persistent
	private String title;// varchar(200) 可为空 内容标题
	@Persistent
	private String slug;// varchar(128) 索引,可为空 内容缩略名
	@Persistent
	private String uri;// varchar(200) 可为空 资源描述符
	@Persistent
	private Integer created;// int(10) 索引,非负,可为空 内容生成时的GMT unix时间戳
	@Persistent
	private Integer modified;// int(10) 非负,可为空 内容更改时的GMT unix时间戳
	@Persistent
	private Text text;// text 可为空 内容文字
	@Persistent
	private String tags;// varchar(200) 可为空 内容标签,冗余字段
	@Persistent
	private Integer meta;// int(10) 索引,非负,可为空 首选项id,冗余字段
	@Persistent
	private Integer author;// int(10) 索引,非负,可为空 内容所属用户id
	@Persistent
	private String template;// varchar(32) 可为空 内容使用的模板
	@Persistent
	private String type;// varchar(32) 索引 内容类别
	@Persistent
	private String password;// varchar(32) 可为空 受保护内容,此字段对应内容保护密码
	@Persistent
	private Integer commentsNum;// int(10) 非负,可为空 内容所属评论数,冗余字段
	@Persistent
	private Boolean allowComment;// enum(enable, disable) 可为空 是否允许评论
	@Persistent
	private Boolean allowPing;// enum(enable, disable) 可为空 是否允许ping
	@Persistent
	private Boolean allowFeed;// enum(enable, disable) 可为空 允许出现在聚合中 

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
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

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public Integer getModified() {
		return modified;
	}

	public void setModified(Integer modified) {
		this.modified = modified;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getMeta() {
		return meta;
	}

	public void setMeta(Integer meta) {
		this.meta = meta;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
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
