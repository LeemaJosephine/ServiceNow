package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificationMethod;
import io.github.sukgu.Shadow;

public class ServiceNow extends ProjectSpecificationMethod{

	//3. Click -All and  Enter Incident in filter navigator and press enter
	
	public ServiceNow(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public IncidentsView filterIncidents() {
		
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(20);
		
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Incidents");
		shadow.findElementByXPath("//mark[text()='Incidents']").click();
	
		return new IncidentsView(driver);
	}
	
}
