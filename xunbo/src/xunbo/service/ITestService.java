package xunbo.service;

import java.util.List;

import xunbo.pojo.Test;

public interface ITestService {
	public void addTest(Test test);
	public List<Test> getAllTest();
	public List<Test> getByProperty(String key, Object value);
}
