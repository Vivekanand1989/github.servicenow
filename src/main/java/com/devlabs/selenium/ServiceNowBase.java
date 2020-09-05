package com.devlabs.selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class ServiceNowBase implements Browser, Element{


	public RemoteWebDriver driver;

	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println("The element is clicked successfully");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element is not cliked");
		}catch (WebDriverException e) {
			System.err.println("Element not clicked "+e.getMessage());
		}finally {
			takeSnap();
		}

	}

	@Override
	public void append(WebElement ele, String data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear(WebElement ele) {
		try {
		ele.clear();
		System.out.println("Element cleared");
		} catch (NoSuchElementException e) {
			System.err.println("Element not found " + e.getMessage());	
		} catch(Exception e) {
			System.err.println("Exception "+ e.getMessage());
		}

	}

	@Override
	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The value " +data + " is typed");
		} catch (NoSuchElementException e) {
			System.err.println("The value " +data + " is not typed"+e.getMessage());
		}catch (Exception e) {
			System.err.println("The value " +data + " is not typed"+e.getMessage());
		}finally {
			takeSnap();
		}
	}

	static int i=0;

	void takeSnap(){
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("snap"+i+".png");
		i++;
		try {
			FileHandler.copy(screenshotAs, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getElementText(WebElement ele) {
		try {
		String eleText = ele.getText();
		System.out.println(eleText);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public String getBackgroundColor(WebElement ele) {
		ele.getCssValue("");
		return null;
	}

	@Override
	public String getTypedText(WebElement ele) {
		ele.getAttribute("value");
		return null;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try{
			Select selDropdown= new Select(ele);
		List<WebElement> options = selDropdown.getOptions();
		for(WebElement allDropdown: options) {
			String textValue = allDropdown.getText();
			if(textValue.equals(value)) {
				allDropdown.click();
			}
			}
		}
			
		 catch(NoSuchElementException e) {
			System.err.println("Element not found " + e.getMessage());
		} catch(WebDriverException e) {
			System.err.println("WebDrive Exception "+ e.getMessage());
		}
			finally {
				takeSnap();
				
			}
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select sel = new Select(ele);
			sel.selectByIndex(index);
			System.out.println("Drop Down is selected");
		} catch (NoSuchElementException e) {
			System.err.println("Not able to select the dropdown using index");
		}catch (WebDriverException e) {
			throw new WebDriverException();
		}finally {
			takeSnap();
		}
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {


	}

	@Override
	public boolean verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyDisappeared(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyEnabled(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startApp(String url) {
		System.out.println("ServiceNowBase.startApp()");
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
            driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Browser running");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void startApp(String browser, String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public WebElement findElementBy(String locatorType, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebElement findElementBy(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElementBys(String type, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void switchToAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void typeAlert(String data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToWindow(String title) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToFrame(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToFrame(String idOrName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultContent() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verifyUrl(String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void quit() {
		driver.quit();

	}

}
