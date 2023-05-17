package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.LoginPage;

public class TC002_UpdateExsistingIncident extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		excelFile="LoginCredentials";
	}
	
	@Test(dataProvider = "ReadExcel")
	public void createIncident(String username, String password) throws IOException {
		
		new LoginPage(driver).userName(username).password(password).clickLoginButton()
		.filterIncidents()
		.searchToUpdate()
		.updateUrgecy()
		.updateState()
		.clickUpdate()
		.updateVerify();
		
	}
}
