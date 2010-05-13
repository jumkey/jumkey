package blog.DAO;

import java.util.List;

import blog.pojo.Contents;

public interface ContentsDAO {
	public List<Contents> getAllContents();

	public void create(Contents contents);

	public Contents retrieve(Long id);

	public void update(Contents contents);

	public void delete(Long id);
}
