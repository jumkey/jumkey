package meetmanager.dao.impl;


import meetmanager.dao.GenericDAOHibernate;
import meetmanager.dao.UserDAO;
import meetmanager.model.User;


public class UserDAOImpl extends GenericDAOHibernate<User, Integer> implements
		UserDAO {
}