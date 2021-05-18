package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FunctionalLibrary.DriverActions;
import Logs.Log;

public class TC001_AccountCreation {
	
	//Creating Objects for DriverActions and Properties Class to access its Methods
	DriverActions action = new DriverActions();
	Properties prop = new Properties();
	
	
	/**Invoke Constructor
	 * Invoked Constructor to Initialize Object for the Properties Class
	 * To Configure Logger 
	 * @throws IOException
	 */
	public TC001_AccountCreation() throws IOException {
		prop = action.getPropertyFile();
		DOMConfigurator.configure("Logger\\Log4j.xml");
	}
	
	
	/**Before Test Method
	 * This Method is to Invoke Browser and to Navigate to Application 
	 * @throws Exception 
	 */
	@BeforeTest
	public void invokeBrowser() throws Exception {
		action.getBrowser("Chrome");
		action.getWebLink(prop.getProperty("getAppLink"));
		action.Wait();
		action.clickWebElement("xpath",prop.getProperty("closepopup"));
	}
	
	
	/** Test Method
	 * This Method is used for Account Creation where we are giving User Details for Account Creation
	 * @throws Exception 
	 */
	@Test
	public void createAccount() throws Exception {
		action.clickWebElement("xpath", prop.getProperty("clickAccount"));
		action.clickWebElement("xpath", prop.getProperty("clickMyAccount"));
		action.inputValues("xpath", prop.getProperty("inputFirstName"), action.ReadTestData("AccountCreation", 2, 0));
		action.inputValues("xpath", prop.getProperty("inputLastName"), action.ReadTestData("AccountCreation", 2, 1));
		action.inputValues("xpath", prop.getProperty("inputEmail"), action.ReadTestData("AccountCreation", 2, 2));
		action.inputValues("xpath", prop.getProperty("inputConfirmEmail"), action.ReadTestData("AccountCreation", 2, 3));
		action.inputValues("xpath", prop.getProperty("inputPassword"), action.ReadTestData("AccountCreation", 2, 4));
		action.inputValues("xpath", prop.getProperty("inputConfirmPassword"), 
				action.ReadTestData("AccountCreation", 2, 5));
		action.ScrollDown();
		action.Wait();
		action.clickWebElementP("xpath", prop.getProperty("clickCreateAccountButton"));
	}
	
	
	/** After Method
	 * This Method is show the Successful Login
	 * @throws Exception
	 */
	@AfterTest
	public void accountCreationSuccess() throws Exception {
		Log.info("AccountCreatedSuccessfully");
		action.Wait();
		action.TakeScreenShot("TC001-01-LoginSuccess");
		action.Quit();		
	}

}
