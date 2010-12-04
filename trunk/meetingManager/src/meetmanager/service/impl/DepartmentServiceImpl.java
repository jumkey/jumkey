package meetmanager.service.impl;

import java.util.List;

import meetmanager.dao.DepartmentDAO;
import meetmanager.model.Department;
import meetmanager.service.DepartmentService;


public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDAO departmentDAO;

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentDAO.findAll();
	}

}
