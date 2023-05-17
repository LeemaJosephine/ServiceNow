package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificationMethod;

public class IncidentsVerification extends ProjectSpecificationMethod{

	public IncidentsVerification(RemoteWebDriver driver) {
		this.driver=driver;
	}

	public IncidentsVerification verifyScreenhot() throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("snap/TC001_CreateNewIncident.png");
		FileUtils.copyFile(source, dest);
		return this;
		
	}
	
}
