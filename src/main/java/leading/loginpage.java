package leading;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver driver;
	public loginpage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath =("//input[@type='text' and @name='vUsername' and @id='vUsername']"))
	WebElement username;
	@FindBy(xpath =("//input[@type='password' and @name='vPassword' and @id='vPassword']"))
	WebElement password;
	@FindBy(xpath =("//a[@id='btn_sign_in']"))
	WebElement login;
	
	
	
	public void setusername(String userid) {
		
		username.sendKeys(userid);
	}

	public void setpassword(String passid) {
		
		password.sendKeys(passid);
	}

	public void log() {
		login.click();
		
	}
	
	public void verifylogin(String user,String pass) {
		
		setusername(user);
		setpassword(pass);
		log();
	}
	
}
