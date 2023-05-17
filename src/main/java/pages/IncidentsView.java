package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificationMethod;
import io.github.sukgu.Shadow;

public class IncidentsView extends ProjectSpecificationMethod{

	//4. Click on Create new button and fill the mandatory fields and Click Submit
	
	public Shadow shadow;
	
	public IncidentsView(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public CreateIncident clickNewButton() {
		shadow=new Shadow(driver);
		
		driver.findElement(By.xpath("//button[text()='New']")).click();
		return new CreateIncident(driver);
	}
	public UpdateIncidentPriority searchToUpdate() {
		shadow=new Shadow(driver);
		WebElement frameName = shadow.findElementByXPath("(//input[@placeholder='Search'])[1]");
		driver.switchTo().frame(frameName);
		WebElement a = shadow.findElementByXPath("//input[text()='Search']");
		String find = shadow.findElementByXPath("//tr[contains(@id,'row_incident')][4]//td[3]").getText();
		a.sendKeys(find,Keys.ENTER);
		WebElement b = shadow.findElementByXPath("//tr[contains(@id,'row_incident')][1]//td[3]");
		b.click();
		return new UpdateIncidentPriority(driver);
	}
	
	

}
