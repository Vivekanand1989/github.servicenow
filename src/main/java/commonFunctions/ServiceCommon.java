package commonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.devlabs.selenium.ServiceNowBase;

import utils.ReadData;

public class ServiceCommon extends ServiceNowBase{
	
	public String excelname;
	
	@Parameters({"url"})
	@BeforeMethod
	public void launchBrowser(String url) {
		System.out.println("ServiceCommon.launchBrowser()");
		startApp(url);
	}
	
	@AfterMethod
	public void closeApp() {
		quit();
	}
	
	
	@DataProvider(name = "login")
	public String[][] testData() {
		System.out.println("ServiceCommon.testData()");
		ReadData rd = new ReadData();
		
		return rd.getData(excelname);
	}
	
}
