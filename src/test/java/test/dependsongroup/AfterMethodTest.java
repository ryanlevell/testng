package test.dependsongroup;

import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.TestNGException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AfterMethodTest {
	
	static String test;

	@Test
	public void testAfterMethodAnnotation() {
		TestNG testng = new TestNG();
		TestListenerAdapter tla = new TestListenerAdapter();
		testng.addListener(tla);
		testng.setTestClasses(new Class[] { AfterMethodSample.class });

		try {
			testng.run();
		} catch (TestNGException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(tla.getPassedTests().size(), 2, "Expected tests to pass");
	}
}

class AfterMethodSample {
	@Test
	public void test1() {
		AfterMethodTest.test = "test1";
	}
	
	@Test
	public void test2() {
		AfterMethodTest.test = "test2";
	}
	
	@AfterMethod(dependsOnMethods = { "test2" })
	public void test4() {
		System.out.println(AfterMethodTest.test);
	}
}

