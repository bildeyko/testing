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
		driver.get(baseUrl);
	}

	@Test
	public void test1() throws Exception {
		WebElement element;
		WebDriverWait wait;
		String tmp;

		element = driver.findElement(By.xpath("//header/div[3]/form/div/input"));
		element.sendKeys("Нолан");

		tmp = "//ul[@class='persons-result']//a[contains(text(),'Кристофер Нолан')]";
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tmp)));
		element = driver.findElement(By.xpath(tmp));
		element.click();

		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1")));
		element = driver.findElement(By.xpath("//h1"));
		assertEquals("Кристофер Нолан", element.getText());
	}

	@Test
	public void test3() throws Exception {
		WebElement element;
		String tmp;

		element = driver.findElement(By.xpath("//header/div[3]/form/div/input"));
		element.sendKeys("Начало");

		element = driver.findElement(By.xpath("//header/div[3]/form/div/button"));
		element.submit();

		tmp = "//section[@class='gallery-wrapper ']/ul/li[2]//span[@class='title']/span";
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tmp)));
		element = driver.findElement(By.xpath(tmp));
		assertEquals("Начало", element.getText());
	}

}
