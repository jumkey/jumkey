package meetmanager.dao.impl;


import meetmanager.dao.UserDAO;
import meetmanager.model.User;
import meetmanager.utils.dao.GenericDAOHibernate;


public class UserDAOImpl extends GenericDAOHibernate<User, Integer> implements
		UserDAO {
}