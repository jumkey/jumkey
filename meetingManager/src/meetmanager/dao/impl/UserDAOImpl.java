package meetmanager.dao.impl;

import java.util.List;

import meetmanager.dao.GenericDAOHibernate;
import meetmanager.dao.UserDAO;
import meetmanager.model.Page;
import meetmanager.model.User;


public class UserDAOImpl extends GenericDAOHibernate<User, Integer> implements
		UserDAO {
}