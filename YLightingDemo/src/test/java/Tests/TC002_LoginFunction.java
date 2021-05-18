package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FunctionalLibrary.DriverActions;
import Logs.Log;

public class TC002_LoginFunction {
	
	public static WebDriver driver;

	//Creating Objects for DriverActions and Properties Class to access its Methods
		DriverActions action = new DriverActions();
		Properties prop = new Properties();
		
		
		/**Invoke Constructor
		 * Invoked Constructor to Initialize Object for the Properties Class
		 * To Configure Logger 
		 * @throws IOException
		 */
		public TC002_LoginFunction () throws IOException {
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
			action.Wait();
		}
		
		/** Test Method
		 * This Method is used for Login Functionality where we are giving User Details for Login
		 * @throws Exception 
		 */
		@Test
		public void Login() throws Exception {
			action.clickWebElement("xpath", prop.getProperty("clickAccount"));
			action.clickWebElement("xpath", prop.getProperty("clickMyAccount"));
			
			action.inputValues("xpath", prop.getProperty("Username"), action.ReadTestData("Login", 2, 1));
			action.inputValues("xpath", prop.getProperty("Password"), action.ReadTestData("Login", 2, 2));
			
			action.Wait();
			action.clickWebElementP("xpath", prop.getProperty("Login"));
			
		}
		
		
		/** After Method
		 * This Method is show the Successful Login
		 * @throws Exception
		 */
		@AfterTest
		public void LoginSuccess() throws Exception {
			Log.info("Logged In Successfully");
			action.Wait();
			action.TakeScreenShot("TC002-02-LoggedInSuccessfully");
			action.Quit();		
		}
}
