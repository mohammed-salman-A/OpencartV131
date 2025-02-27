	package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Regression","Master"})
	void verify_login() {
		try {
				
			logger.info("*** Starting verifyLogin Test");
	        
	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        logger.info("Clicked on 'My Account'");
	        hp.clickLogin();
	        logger.info("Clicked on 'Login'");
	        
	        LoginPage lp = new LoginPage(driver);
	        
	        lp.setEmail(p.getProperty("email"));
	        lp.setPassword(p.getProperty("password"));
	        lp.clickLoginBtn();
	        
	        MyAccountPage acc = new MyAccountPage(driver);
	        Assert.assertTrue(acc.isMyAccountExist(), "My Account page does not exist after login.");
	    }
		catch(Exception e) {
	        Assert.fail("Login test	failed");
	    }

		logger.info("**Finished Login Test**");
		
		
	}
}
