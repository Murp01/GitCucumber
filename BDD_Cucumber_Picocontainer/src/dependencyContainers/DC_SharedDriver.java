package dependencyContainers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class DC_SharedDriver {
	
	private static boolean startBrowser = false;
	//when sharedclass is executed it checks if the browser is currently running.  
	
	private WebDriver driver;
	//private webdriver type is created can only be used when ...
	
	@Before
	public void init() throws Exception{
		/*this method will run before each scenario.  When a scenario starts it will first
		 * come to this method. The if statement checks if the scenario has completed and been closed following
		 * the @After method.  If !startBrowser is true then it will open an instance of firefoxDriver.  Following
		 * This it will change teh startBrowser variable to true so it will know not to instantiate another driver
		 * and resetting it causing all manner of havoc within multiple step Definitions
		 */
		if(!startBrowser) {
			
			driver = new FirefoxDriver();
			
			
			startBrowser = true;
		}
	}	
	
	public WebDriver getDriver() {
		/*This method is what will be called on all of the stepdefinition files.  The returned driver is the driver
		 * that has been instantiated and controlled within this file
		 */
		return driver;
	}
		
	@After
	public void cleanUp() {
		/*After the scenario has been completed it will come to this @After hook.  The method within will close
		 * reset the driver that has been instantiated on this page.  The next scenario will then loop back to the
		 * @Before hook which will then run the method to check if the driver is currently open or closed
		 */
		driver.close();
		driver.quit();
	}

}
