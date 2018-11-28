package objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePageObjects extends BasePage {

	@FindBy(xpath = ".//*[@class='logo img-responsive']")
	private WebElement logo;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
	private WebElement tabWomen;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement tabDresses;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement tabTshirts;

	@FindBys(@FindBy(xpath = ".//*[contains(@id,'deals-shoveler')]//ul/li"))
	List<WebElement> lstProducts;

	@FindBys(@FindBy(xpath = ".//*[contains(@class,'fixed-left-grid-col rightCol')]//*[contains(@id,'dealView')]//div[contains(@class,'priceBlock')]/span"))
	List<WebElement> lstProductPrice;

	@FindBy(name = "sortOptions")
	private WebElement dropDownSort;

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getDresses() {
		return tabDresses;
	}

	public WebElement getTshirts() {
		return tabTshirts;
	}

	public WebElement getWomen() {
		return tabWomen;
	}

	public void clickWomen() {
		tabWomen.click();
	}

	public void clickDresses() {
		tabDresses.click();
	}

	public void clickTShirts() {
		tabTshirts.click();
	}

	public List<WebElement> getProductsInDeals() {
		return lstProducts;
	}

	public boolean verifyProductPrice(WebElement parent) {
		return elementFound(parent.findElement(By.xpath(".//*[@class='dealPrice']")));

	}

	public String getProductName(WebElement parent) {
		return parent.findElement(By.xpath(".//*[@class='deals-shoveler-card-image']//img")).getAttribute("title");
	}

	public void selectSortDropDown(String input) {
		selectFromDropDown(dropDownSort, input);
	}

	public ArrayList<Double> getDealProductPrices() {
		ArrayList<Double> prices = new ArrayList<Double>();

		for (WebElement product : lstProductPrice) {
			String text = product.getText().replace("₹", "").replace(",", "").split("-")[0].trim();
			System.out.println(text);
			Double value = Double.parseDouble(text);
			prices.add(value);
			System.out.println(value);
		}
		return prices;
	}

}
