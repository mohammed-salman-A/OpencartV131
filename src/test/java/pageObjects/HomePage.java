package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='caret']") WebElement myaccount;
	@FindBy(xpath="//li[normalize-space()='Register']") WebElement register;
	@FindBy(xpath="//li[normalize-space()='Login']") WebElement login;
	
	public void clickMyAccount() {
		myaccount.click();
	}
	public void clickRegister() {
		register.click();
	}
	public void clickLogin() {
		login.click();
	}
	
}

