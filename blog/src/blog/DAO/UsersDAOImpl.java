package blog.DAO;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import blog.db.PMF;
import blog.pojo.Users;

public class UsersDAOImpl implements UsersDAO {

	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + Users.class.getName();
		try {
			List<Users> users = (List<Users>) pm.newQuery(query).execute();
			pm.detachCopyAll(users);
			return users;
		} catch (Exception e) {
			return null;
		} finally {
			pm.close();
		}
	}
	@SuppressWarnings("unchecked")
	public Users getUsersByNP(String name,String password){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String querystr = "select from " + Users.class.getName()+" where name=='"+name+"'&&password=='"+password+"'";
	    Query query = pm.newQuery(querystr);
	    try{
	        List<Users> users = (List<Users>) query.execute();
	        pm.detachCopyAll(users);
	        Users user=null;
	        if(users!=null&&users.size()!=0){
	        	user = users.get(0);
	        }
	        return user;
	    }finally{
	        query.closeAll();
	        pm.close();
	    }
	}
	@SuppressWarnings("unchecked")
	public Users getUsersByName(String name) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String querystr = "select from " + Users.class.getName()+" where name=='"+name+"'";
	    Query query = pm.newQuery(querystr);
	    try{
	        List<Users> users = (List<Users>) query.execute();
	        pm.detachCopyAll(users);
	        Users user=null;
	        if(users!=null&&users.size()!=0){
	        	user = users.get(0);
	        }
	        return user;
	    }finally{
	        query.closeAll();
	        pm.close();
	    }
	}

	public void create(Users users) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(users);
		} finally {
			pm.close();
		}
	}

	public Users retrieve(Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Users users = pm.getObjectById(Users.class, id);
			pm.detachCopy(users);
			return users;
		} catch (Exception e) {
			return null;
		} finally {
			pm.close();
		}
	}

	public void update(Users users) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Users original = pm.getObjectById(Users.class, users.getUid());
			original.setName(users.getName());
			original.setPassword(users.getPassword());
			pm.makePersistent(original);
		} finally {
			pm.close();
		}
	}

	public void delete(Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Users users = pm.getObjectById(Users.class, id);
			pm.deletePersistent(users);
		} finally {
			pm.close();
		}
	}
}
