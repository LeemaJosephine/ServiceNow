package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.ReadExcel;

public class ProjectSpecificationMethod {

	//1. Launch ServiceNow application
	
	public RemoteWebDriver driver;
	public String excelFile;
	public String screenshotName;
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev143608.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void closeBrowser() {
		//driver.close();
	}
	
	@DataProvider(name="ReadExcel")
	public String[][] readExcel() throws IOException {
		String[][] readData = ReadExcel.readExcelSheet(excelFile);
		return readData;
		
	}
}
