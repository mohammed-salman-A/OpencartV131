package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	@Test(groups={"sanity","Master"})
	void verify_Account_Registration() {
		
		try {
			logger.info("*****Executing verify_Account_Registration****");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on myaccount");
			hp.clickRegister();
			logger.info("clicked on register");

			
			RegistrationPage regpage = new RegistrationPage(driver);
			regpage.setFirstname(randomAlphabetic().toUpperCase());
			regpage.setLastname(randomAlphabetic().toUpperCase());
			regpage.setEmail(randomAlphabetic()+"@gmail.com");
			regpage.setTelephone(randomNumeric());
			String password = randomAlphaNumric();
			regpage.setPassword(password);
			regpage.setConfPassword(password);
			regpage.ClickAgreeBtn();
			regpage.clickContinueBtn();
			
			logger.info("verifying the Account Created message");

			Assert.assertEquals(regpage.verify_msg(), "Your Account Has Been Created!");
		
		
		}
		catch(Exception e) {
			logger.error("error logs....");
//			logger.debug("debug logs....");
			Assert.fail();
		}
	
	}
	
	
	
}
