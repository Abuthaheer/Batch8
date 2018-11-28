package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.BasePage;
import objects.DressesPageObject;
import objects.HomePageObjects;

public class HomePageTests {

	HomePageObjects hp;
	BasePage bp;
	DressesPageObject dp;

	public HomePageTests() {
		hp = new HomePageObjects();
		bp = new BasePage();
		dp = new DressesPageObject();
	}

	@Test
	public void verifyLogo() {
		Assert.assertTrue(bp.elementFound(hp.getLogo()));
	}

	@Test
	public void verifyTabTexts() {
		System.out.println("Text == >" + hp.getDresses().getText());
		Assert.assertTrue(hp.getDresses().getText().equals("DRESSES"), "Failed: Tab does not contain Dresses Text");
		Assert.assertTrue(hp.getWomen().getText().equals("WOMEN"));

	}

	@Test
	public void verifyMenuNavigation() {
		hp.clickWomen();
		System.out.println(dp.getHeader().getText());
		Assert.assertTrue(dp.getHeader().getText().trim().equals("WOMEN"), "Failed: Women page is not displayed");
		hp.clickDresses();
		System.out.println(dp.getHeader().getText());
		Assert.assertTrue(dp.getHeader().getText().trim().equals("DRESSES"), "Failed: Dresses page is not displayed");
		hp.clickTShirts();
		System.out.println(dp.getHeader().getText());
		Assert.assertTrue(dp.getHeader().getText().trim().equals("T-shirts"), "Failed: Dresses page is not displayed");

	}

	/*@Test
	public void verifyProductPriceinDealnProducts() {
		List<WebElement> dealProduts = hp.getProductsInDeals();
		for (WebElement product : dealProduts) {
			Assert.assertTrue(hp.verifyProductPrice(product),
					"Failed: Product price not displayed for Product ==> " + hp.getProductName(product));
		}
	}

	@Test
	public void verifyProductPriceAscendingOrder() {
		hp.selectSortDropDown("BY_PRICE_ASCENDING");
		ArrayList<Double> prices = hp.getDealProductPrices();
		for (int i = 0; i < prices.size() - 1; i++) {
			Assert.assertTrue(prices.get(i) <= prices.get(i + 1), "Failed: Not in ascending Order");
		}

	}
*/
}
