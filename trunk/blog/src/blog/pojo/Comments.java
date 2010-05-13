package blog.pojo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Comments {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long coid;// int(10) 主键,非负,自增 comment表主键
	@Persistent
	private Integer cid;// int(10) 索引,非负 post表主键,关联字段
	@Persistent
	private Integer created;// int(10) 非负,可为空 评论生成时的GMT unix时间戳
	@Persistent
	private String author;// varchar(200) 可为空 评论作者
	@Persistent
	private String mail;// varchar(200) 可为空 评论者邮件
	@Persistent
	private String url;// varchar(200) 可为空 评论者网址
	@Persistent
	private String ip;// varchar(64) 可为空 评论者ip地址
	@Persistent
	private String agent;// varchar(200) 可为空 评论者客户端
	@Persistent(serialized="true", defaultFetchGroup="true")
	private Text text;// text 可为空 评论文字
	@Persistent
	private String type;// enum('pingback', 'trackback', 'comment') 可为空 评论类型
	@Persistent
	private String status;// enum('approved', 'spam', 'waiting') 可为空 评论状态
	@Persistent
	private Integer parent;// int(10) 可为空 父级评论

	public Long getCoid() {
		return coid;
	}

	public void setCoid(Long coid) {
		this.coid = coid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

}
