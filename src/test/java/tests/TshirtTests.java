package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TshirtTests {

	
	
	@Test(groups = {"Regression"})
	public void testCase1() {
		System.out.println("in test case 1");
	}

	// test case 2
	@Test(groups = {"Sanity", "Regression"})
	public void testCase2() {
		System.out.println("in test case 2");
	}

	@Test(groups = {"SIT"})
	public void testCase3() {
		System.out.println("in test case 2");
	}

	@Test(groups = {"Smoke"})
	public void testCase4() {
		System.out.println("in test case 2");
	}

}
