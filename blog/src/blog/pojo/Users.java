package blog.pojo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Users {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long uid;// int(10) 主键,非负,自增 user表主键
	@Persistent
	private String name;// varchar(32) 唯一 用户名称
	@Persistent
	private String password;// varchar(32) 可为空 用户密码
	@Persistent
	private String mail;// varchar(200) 唯一 用户的邮箱
	@Persistent
	private String url;// varchar(200) 可为空 用户的主页
	@Persistent
	private String screenName;// varchar(32) 可为空 用户显示的名称
	@Persistent
	private Integer created;// int(10) 非负,可为空 用户注册时的GMT unix时间戳
	@Persistent
	private Integer activated;// int(10) 非负,可为空 最后活动时间
	@Persistent
	private Integer logged;// int(10) 非负,可为空 上次登录最后活跃时间
	@Persistent
	private String group;// enum('administrator', 'editor', 'contributor',
							// 'subscriber', 'visitor') N/A 用户组

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public Integer getActivated() {
		return activated;
	}

	public void setActivated(Integer activated) {
		this.activated = activated;
	}

	public Integer getLogged() {
		return logged;
	}

	public void setLogged(Integer logged) {
		this.logged = logged;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
