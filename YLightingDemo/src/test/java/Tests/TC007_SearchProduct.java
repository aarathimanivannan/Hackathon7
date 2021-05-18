package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FunctionalLibrary.DriverActions;
import jdk.internal.org.jline.utils.Log;

public class TC007_SearchProduct {

	//Creating Objects for DriverActions and Properties Class to access its Methods
	DriverActions action = new DriverActions();
	Properties prop = new Properties();
	
	
	/**Invoke Constructor
	 * Invoked Constructor to Initialize Object for the Properties Class
	 * To Configure Logger 
	 * @throws IOException
	 */
	public TC007_SearchProduct() throws IOException {
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
	
	@Test(priority=1)
	public void Searchproduct() throws Exception {
		action.inputValues("xpath", prop.getProperty("Enterproduct"), action.ReadTestData("Data", 1, 0));
		action.clickWebElementP("xpath", prop.getProperty("Search"));
		action.Wait();
		action.clickWebElementP("xpath", prop.getProperty("Addproduct"));
		action.Wait();
		action.ScrollDown();
		action.Wait();
		action.clickWebElementP("xpath", prop.getProperty("Addfantocart"));
		action.Wait();
		action.clickWebElementP("xpath", prop.getProperty("CartCheckout"));
	}
	
	/** After Method
	 * This Method is show the Successful Login
	 * @throws Exception
	 */

	@AfterTest
	public void searchscreenshot() throws Exception {
		
		action.Wait();
		action.TakeScreenShot("TC006-06-Searchproduct");
		action.Quit();		
	}
}
