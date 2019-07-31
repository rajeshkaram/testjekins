package testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import leading.loginpage;

public class logintestcase {

	
	WebDriver driver;
	String sheetname="login";
	loginpage login;
	
	
	@BeforeTest
	public void startsession() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rajesh.k\\Downloads\\76driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://calcasieu.dev.leateamapps.com/");
		
	}
	
	@DataProvider
	public Object[][] getexcel() throws IOException{
		Object[][] data=leading.excelreader.gettestldata(sheetname);
		return data;
	}
	
	@Test(dataProvider="getexcel")
	
	public void veri(String usid,String pasid) {
		login=new loginpage(driver);
		login.verifylogin(usid, pasid);
	}
	
	
	
	//@AfterTest
	public void closebrowser() {
		
		driver.close();
	}
}

