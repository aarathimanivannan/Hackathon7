package Tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FunctionalLibrary.DriverActions;

public class TC008_Livechat_Validcredentials {


	//Creating Objects for DriverActions and Properties Class to access its Methods
	DriverActions action = new DriverActions();
	Properties prop = new Properties();
	
	
	/**Invoke Constructor
	 * Invoked Constructor to Initialize Object for the Properties Class
	 * To Configure Logger 
	 * @throws IOException
	 */
	public TC008_Livechat_Validcredentials() throws IOException {
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
	 * This Method is used for Login Functionality where we are giving User Details for Login
	 * @throws Exception 
	 */
	@Test(priority=0)
	public void Login() throws Exception {
		action.clickWebElement("xpath", prop.getProperty("clickAccount"));
		action.clickWebElement("xpath", prop.getProperty("clickMyAccount"));
		
		action.inputValues("xpath", prop.getProperty("Username"), action.ReadTestData("Login", 2, 1));
		action.inputValues("xpath", prop.getProperty("Password"), action.ReadTestData("Login", 2, 2));
		
		action.Wait();
		action.clickWebElementP("xpath", prop.getProperty("Login"));
		
		action.Wait();
	}
	
	/** Test Method
	 * This Method is used for navigating to Livechat with valid credentials
	 * @throws Exception 
	 */
	@Test(priority=0)
	public void Livechat() throws Exception {
		
		action.Wait();
		action.clickWebElement("xpath", prop.getProperty("LiveChat"));
		action.Wait();
		
	}
		/** After Method
		 * This Method is show the Successful Login
		 * @throws Exception
		 */

		@AfterTest
		public void selectlivechat() throws Exception {
			
			action.Wait();
			action.TakeScreenShot("TC006-06-Searchproduct");
			action.Quit();		
		}
	}

