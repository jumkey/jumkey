package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.DepartmentDAO;
import com.onegrid.meetmanager.model.Department;
import com.onegrid.meetmanager.service.DepartmentService;

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
