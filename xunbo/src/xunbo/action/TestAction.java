package xunbo.action;

import java.util.List;

import xunbo.pojo.Test;
import xunbo.service.ITestService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport{
	private ITestService testservice;

	public ITestService getTestservice() {
		return testservice;
	}

	public void setTestservice(ITestService testservice) {
		this.testservice = testservice;
	}

	public String add(){
		testservice.addTest(test);
		//tests=testservice.getByProperty("title", "11");
		tests=testservice.getAllTest();
		return "success";
	}
	private Test test;
	private List<Test> tests;

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

}
