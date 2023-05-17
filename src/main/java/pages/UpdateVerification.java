package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificationMethod;
import io.github.sukgu.Shadow;

public class UpdateVerification extends ProjectSpecificationMethod{

	public Shadow shadow;
	public UpdateVerification(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public UpdateVerification updateVerify() {
		WebElement verifyFrame = shadow.findElementByXPath("//iframe[@id='Main Content']");
		driver.switchTo().frame(verifyFrame);
		shadow.findElementByXPath("//tr[contains(@id,'row_incident')][1]//td[3]").click();
		String urgency = shadow.findElementByXPath("//id[@id='incident.urgency']").getText();
		String state = shadow.findElementByXPath("//id[@id='incident.state']").getText();
		if(urgency.contains("Medium")) { System.out.println("Urgency is 2-Moderate");} else System.out.println("Urgency: " +urgency);
		if(state.contains("In progress")) { System.out.println("State is in In-progress");} else System.out.println("State: " +state);
		return this;
	}

	
}

