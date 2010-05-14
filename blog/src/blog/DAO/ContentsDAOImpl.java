package blog.DAO;

import java.util.List;

import javax.jdo.PersistenceManager;

import blog.db.PMF;
import blog.pojo.Contents;

public class ContentsDAOImpl implements ContentsDAO {
	public void create(Contents contents) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(contents);
		} finally {
			pm.close();
		}
	}

	public Contents retrieve(Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Contents contents = pm.getObjectById(Contents.class, id);
			pm.detachCopy(contents);
			return contents;
		} catch (Exception e) {
			return null;
		} finally {
			pm.close();
		}
	}
	
	public void update(Contents contents) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Contents original = pm.getObjectById(Contents.class, contents.getCid());
			original.setTags(contents.getTags());
			original.setMeta(contents.getMeta());
			original.setPassword(contents.getPassword());
			pm.makePersistent(original);
		} finally {
			pm.close();
		}
	}

	public void delete(Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Contents contents = pm.getObjectById(Contents.class, id);
			pm.deletePersistent(contents);
		} finally {
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Contents> getAllContents() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + Contents.class.getName();
		try {
			List<Contents> contents = (List<Contents>) pm.newQuery(query).execute();
			pm.detachCopyAll(contents);
			// contents.size();//Tell me why?
			return contents;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			pm.close();
		}
	}
}
