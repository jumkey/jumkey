package blog.pojo;

public class Relationships {
	private Long cid;// int(10) 主键,非负 内容主键
	private Long mid;// int(10) 主键,非负 项目主键

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

}
