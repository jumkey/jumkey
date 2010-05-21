package blog.DAO;

import blog.pojo.EEFile;

public interface FileDAO {
	public void addFile(EEFile file);
	public EEFile retrieve(Long id);
}
