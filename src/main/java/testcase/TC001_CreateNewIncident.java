package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.LoginPage;

public class TC001_CreateNewIncident extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		excelFile="TC001_CreateNewIncident";
	}
	
	@Test(dataProvider = "ReadExcel")
	public void createIncident(String username, String password, String caller, String shortDesc) throws IOException {
		
		new LoginPage(driver)
		.userName(username)
		.password(password)
		.clickLoginButton()
		.filterIncidents()
		.clickNewButton()
		.enterShortDesc(shortDesc)
		.clickSubmit()
		.verifyIncidentNumber()
		.verifyScreenhot();
	}
	
}
