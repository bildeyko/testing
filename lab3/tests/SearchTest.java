import com.thoughtworks.selenium.*;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.bildeyko.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class SearchTest {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = Browser.get();
		baseUrl = "http://www.ivi.ru/";
	}

	/*@Test
	public void test1() throws Exception {
		driver.get(baseUrl);
		selenium.open("/");
		selenium.type("//header/div[3]/form/div/input", "Нолан");
		selenium("//header/div[3]/form/div/input", "Нолан");
		selenium.click("//ul[@class='persons-result']//a[contains(text(),'Кристофер Нолан')]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Кристофер Нолан", selenium.getText("//h1"));
	}*/

	@Test
	public void test3() throws Exception {
		driver.get(baseUrl);
		WebElement element;
		element = driver.findElement(By.xpath("//header/div[3]/form/div/input"));
		element.sendKeys("Начало");

		element = driver.findElement(By.xpath("//header/div[3]/form/div/button"));
		element.click();
		//element.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='gallery-wrapper ']/ul/li[2]//span[@class='title']/span")));
		element = driver.findElement(By.xpath("//section[@class='gallery-wrapper ']/ul/li[2]//span[@class='title']/span"));
		assertEquals("Начало", element.getText());
	}

}
