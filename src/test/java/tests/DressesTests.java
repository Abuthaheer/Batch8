package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objects.DressesPageObject;
import objects.HomePageObjects;

public class DressesTests {

	HomePageObjects hp;
	DressesPageObject dp;

	public DressesTests() {
		hp = new HomePageObjects();
		dp = new DressesPageObject();
	}
	
	@BeforeMethod()
	public void beforeDependency(){
		hp.clickDresses();
	}

	@Test
	public void verifyProductCount() {
		Assert.assertTrue(dp.getCountFromHeaderTxt() == dp.getProductCount(), "Failed: Count Mismatched");
	}

}
