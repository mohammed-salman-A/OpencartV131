package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="loginData" ,dataProviderClass=DataProviders.class , groups="DataProvider")
	void verify_LoginDDT(String email,String pwd , String exp) {
		
		
		logger.info("**Startinge the verify_LoginDDT Test**");
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLoginBtn();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountExist();
				
		logger.info("validation");
		try {
			if(exp.equalsIgnoreCase("valid")) {
				if(targetPage==true) {
					
					macc.clickLogoutBtn();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("invalid")) {
				if(targetPage==true) {
					macc.clickLogoutBtn();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e) {
			
		}
		
	}
}
