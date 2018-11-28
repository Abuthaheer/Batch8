package objects;

import java.io.File;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BasePage {

	public static WebDriver driver;
	public String browser = "chrome";

	public BasePage() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:/Users/35775/Desktop/automation/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("ff")) {
				System.setProperty("webdriver.gecko.driver", "C:/Users/abu/workspace/Pom/Driver/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php");
		}
	}

	public JsonObject readJSON() {

		JsonParser parser = new JsonParser();
		JsonObject object = null;

		try {
			File file = new File("./src/test/resources/config.json");
			Object obj = parser.parse(new FileReader(file.getAbsolutePath()));
			object = (JsonObject) obj;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public boolean elementFound(WebElement element) {
		boolean res = false;
		try {
			res = element.isDisplayed();
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	public void setText(WebElement element, String name) {
		if (name != null) {
			element.click();
			element.clear();
			element.sendKeys(name + Keys.ENTER + Keys.ARROW_DOWN + Keys.ARROW_DOWN);
		}
	}

	public String getTxtAttribute(WebElement element, String att) {
		return element.getAttribute(att);
	}

	public String selectFromDropDown(WebElement element, String option) {
		Select obj = new Select(element);
		obj.selectByValue(option);
		return obj.getFirstSelectedOption().getText();
	}

	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementInVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementVisible(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getTitlte() {
		return driver.getTitle();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void quitDriver() {
		driver.quit();
	}

	public void mouseHove(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
		ac.contextClick(element).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).build().perform();
	}

}
