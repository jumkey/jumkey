package xunbo.service.impl;

import java.util.List;

import xunbo.dao.ITestDAO;
import xunbo.pojo.Test;
import xunbo.service.ITestService;

public class TestServiceImpl implements ITestService {
	private ITestDAO testdao;

	public ITestDAO getTestdao() {
		return testdao;
	}

	public void setTestdao(ITestDAO testdao) {
		this.testdao = testdao;
	}

	public void addTest(Test test) {
		testdao.saveEntity(test);
	}

	public List<Test> getAllTest() {
		return testdao.getAllEntity();
	}
	
	public List<Test> getByProperty(String key, Object value) {
		return testdao.findByProperty(key,value);
	}
}
