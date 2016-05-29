import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.bildeyko.*;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class SearchTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		String browser = Browser.get();

		selenium = new DefaultSelenium("localhost", 4444, browser, "http://www.ivi.ru/");
		selenium.start();
	}

	@Test
	public void testSearch() throws Exception {
		selenium.open("/");
		selenium.type("//header/div[3]/form/div/input", "Начало");
		selenium.typeKeys("//header/div[3]/form/div/input", "Начало");
		selenium.click("//header/div[3]/form/div/button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Начало", selenium.getText("//section[@class='gallery-wrapper ']/ul/li[2]//span[@class='title']/span"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
