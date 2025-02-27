package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']") WebElement email;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement login;
	
	public void setEmail(String usr_email) {
		email.sendKeys(usr_email);
	}
	public void setPassword(String usr_password) {
		password.sendKeys(usr_password);
	}
	public void clickLoginBtn() {
		login.click();
	}
}
