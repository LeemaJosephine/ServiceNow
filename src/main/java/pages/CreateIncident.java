package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificationMethod;
import io.github.sukgu.Shadow;

public class CreateIncident extends ProjectSpecificationMethod{
	
	//5. Verify the newly created incident ( copy the incident number and paste it in search field and enter then verify the instance number created or not)
 
	public String incidentNumber;
	public String searchResult;
	public Shadow shadow;
	
	public CreateIncident(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public CreateIncident enterShortDesc(String shortDesc) {
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(shortDesc);
		return this;
	}
	
	public CreateIncident clickSubmit() {
		shadow=new Shadow(driver);
		WebElement frameName = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frameName);
		incidentNumber = shadow.findElementByXPath("//input[@name='incident.number']").getText();
		System.out.println(incidentNumber);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		return this;
	}
	public IncidentsVerification verifyIncidentNumber() {
		
		driver.findElement(By.xpath("//span[@id='incident_hide_search']//input[@placeholder='Search']")).sendKeys(incidentNumber,Keys.ENTER);
		searchResult = driver.findElement(By.xpath("//tr[contains(@id,'row_incident')][1]//td[3]")).getText();
		if(incidentNumber.contains(searchResult)) {
			System.out.println("Incident Created sucesfully");
		} else System.out.println("Unsucessfull :( Incident was not crearted" +incidentNumber);
		return new IncidentsVerification(driver);
	
	}
}
