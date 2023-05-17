package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificationMethod;
import io.github.sukgu.Shadow;

public class UpdateIncidentPriority extends ProjectSpecificationMethod{

	public Shadow shadow;
	public UpdateIncidentPriority(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	public UpdateIncidentPriority updateUrgecy() {
		WebElement urgency = shadow.findElementByXPath("//id[@id='incident.urgency']");
		Select select=new Select(urgency);
		select.selectByIndex(1);
		return this;
	}
	
	public UpdateIncidentPriority updateState() {
		WebElement state = shadow.findElementByXPath("//id[@id='incident.state']");
		Select select1=new Select(state);
		select1.selectByIndex(2);
		return this;
	}
	
	public UpdateVerification clickUpdate() {
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		return new UpdateVerification(driver);
	}

}
