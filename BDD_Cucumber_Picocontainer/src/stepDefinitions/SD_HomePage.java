package stepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SD_HomePage {
	public WebDriver driver;
	
	
	@Before
	public void testSetUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Eclipse\\Webdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@After
	public void testTearDown() {
		driver.close();
	}
	
	
	@Given("^the user is on the homepage$")
	public void WebDriverInitializer() {
		//System.setProperty("webdriver.gecko.driver", "C:\\Eclipse\\Webdrivers\\geckodriver.exe");
		//driver = new FirefoxDriver();
		driver.get("https://linklaters.com");
	}
	
	
	@When("^the user clicks on the AboutUs title$")
	public void the_user_clicks_on_the_AboutUs_title() throws Throwable {
		driver.findElement(By.xpath("//a[@href='/en/about-us']")).click();
	}

	@Then("^confirm the webpages title$")
	public void confirm_the_webpages_title() throws Throwable {

	}

}
