package blog.DAO;

import javax.jdo.PersistenceManager;

import blog.db.PMF;
import blog.pojo.EEFile;

public class FileDAOImpl implements FileDAO {

	@Override
	public void addFile(EEFile file) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(file);
		} finally {
			pm.close();
		}
	}

	@Override
	public EEFile retrieve(Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			EEFile file = pm.getObjectById(EEFile.class, id);
			pm.detachCopy(file);
			return file;
		} catch (Exception e) {
			return null;
		} finally {
			pm.close();
		}
	}

}
