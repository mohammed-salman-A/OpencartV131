package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement verify_msg;
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") WebElement logoutBtn;
	
	public boolean isMyAccountExist() {
		try {
			return (verify_msg.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	public void clickLogoutBtn() {
		logoutBtn.click();
	}
	
}
