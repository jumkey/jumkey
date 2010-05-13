package blog.pojo;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Options {
	@PrimaryKey
	private String name;// varchar(32) 主键 配置名称
	@Persistent
	private Integer user;// int(10) 主键,非负 配置所属用户,默认为0(全局配置)
	@Persistent(serialized="true", defaultFetchGroup="true")
	private Text value;// text 可为空 配置值

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Text getValue() {
		return value;
	}

	public void setValue(Text value) {
		this.value = value;
	}

}
