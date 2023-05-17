package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificationMethod;

public class LoginPage extends ProjectSpecificationMethod{

	//2. Login with valid credentials
	
	public LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public LoginPage userName(String username) {
		driver.findElement(By.id("user_name")).sendKeys(username);
		return this;
	}
	public LoginPage password(String password) {
		driver.findElement(By.id("user_password")).sendKeys(password);
		return this;
	}
	public ServiceNow clickLoginButton() {
		driver.findElement(By.id("sysverb_login")).click();
		return new ServiceNow(driver);
	}
}
