package blog.pojo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Metas {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long mid;// int(10) 主键,非负 项目主键
	@Persistent
	private String name;// varchar(200) 可为空 名称
	@Persistent
	private String slug;// varchar(128) 索引,可为空 项目缩略名
	@Persistent
	private String type;// varchar(32) 索引 项目类型
	@Persistent
	private String description;// varchar(200) 可为空 选项描述
	@Persistent
	private Integer count;// int(10) 非负,可为空 项目所属内容个数
	@Persistent
	private Integer sort;// int(10) 非负,索引,可为空 项目排序

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
