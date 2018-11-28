package objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DressesPageObject extends BasePage {

	@FindBy(xpath = "//*[@class='cat-name']")
	private WebElement header;

	@FindBy(xpath = ".//*[@class='heading-counter']")
	private WebElement txtHeader;

	@FindBys(@FindBy(xpath = ".//*[@class='product_list grid row']/li"))
	private List<WebElement> lstProducts;

	public DressesPageObject() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeader() {
		return header;
	}

	public int getCountFromHeaderTxt() {

		return Integer.parseInt(txtHeader.getText().split(" ")[2]);

		/*
		 * String headerText = txtHeader.getText(); String[] arr =
		 * headerText.split(" "); String txtNumber = arr[2]; int number =
		 * Integer.parseInt(txtNumber); return number;
		 */
	}

	public int getProductCount() {
		return lstProducts.size();
	}

}
