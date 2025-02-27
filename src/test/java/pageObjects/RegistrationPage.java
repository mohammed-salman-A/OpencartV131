package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']") WebElement txt_firstname;
	@FindBy(xpath="//input[@name='lastname']") WebElement txt_lastname;
	@FindBy(xpath="//input[@name='email']") WebElement txt_email;
	@FindBy(xpath="//input[@name='telephone']") WebElement txt_telephone;
	@FindBy(xpath="//input[@name='password']") WebElement txt_pwd;
	@FindBy(xpath="//input[@name='confirm']") WebElement txt_confpwd;
	@FindBy(xpath="//input[@name='agree']") WebElement agree;
	@FindBy(xpath="//input[@value='Continue']") WebElement continue_btn;

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confmassage;

	public void setFirstname(String fname) {
		txt_firstname.sendKeys(fname);
	}
	public void setLastname(String lname) {
		txt_lastname.sendKeys(lname);
	}
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txt_telephone.sendKeys(telephone);
	}
	public void setPassword(String pwd) {
		txt_pwd.sendKeys(pwd);
	}
	public void setConfPassword(String pwd) {
		txt_confpwd.sendKeys(pwd);
	}
	public void ClickAgreeBtn() {
		agree.click();
	}
	public void clickContinueBtn() {
		continue_btn.click();
	}
	
	public String verify_msg() {
		try {
			return confmassage.getText();
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
}

