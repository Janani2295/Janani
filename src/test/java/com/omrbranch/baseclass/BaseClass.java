package com.omrbranch.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	JavascriptExecutor executor;
	protected static WebDriver driver;
	Select select;

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\config\\config.properties"));

		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}

	public void browserLaunch() {
//		switch(browserType) {
//		case "CHROME":
			driver = new ChromeDriver();
//			break;
//		case "IE":
//			driver = new InternetExplorerDriver();
//			break;
//		case "EDGE":
//			driver = new EdgeDriver();
//			break;
//		case "FIREFOX":
//			driver = new FirefoxDriver();
//			break;
//
//		default:
//			break;
//		}

	}

	public static String getProjectPath() {
		String property = System.getProperty("user.dir");
		return property;
	}

	public void scroll(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView()", element);

	}

	public List<String> getAllOptionsText(WebElement element) {
		List<String> allOptionsText = new ArrayList<>();

		List<WebElement> options = new Select(element).getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptionsText.add(text);
		}
		return allOptionsText;
	}

	public void screenshot(String fileName, WebElement element) throws IOException {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(getProjectPath() + "\\images\\" + fileName + ".png"));
	}

	public void screenshot(String fileName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(getProjectPath() + "\\images\\" + fileName + ".png"));
	}

	public void switchToChildwindow() {

		String windowHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String eachWindow : windowHandles) {
			if (!windowHandle.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
			}
		}

	}

	public void visiblityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void impliciwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void impliciwait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public void elementSendKeysJS(WebElement element, String data) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public void enterApplnUrl(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendKeys(WebElement element, String data) {
		visiblityOfElement(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data);
		}
	}

	public void elementClick(WebElement element) {
		visiblityOfElement(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.click();

		}
	}

	public void jsClick(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);

	}

	public void elementSendKeysEnter(WebElement element, String data) {
		visiblityOfElement(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data, Keys.ENTER);
		}
	}

	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

	public WebElement findLocatorById(String attributeValue) {
		WebElement findElement = driver.findElement(By.id(attributeValue));
		return findElement;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement findElement = driver.findElement(By.name(attributeValue));
		return findElement;
	}

	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement findElement = driver.findElement(By.className(attributeValue));
		return findElement;
	}

	public WebElement findLocatorByXpath(String xpathExp) {
		WebElement findElement = driver.findElement(By.xpath(xpathExp));
		return findElement;
	}

	public WebElement findLocatorByTagName(String tagName) {
		WebElement findElement = driver.findElement(By.tagName(tagName));
		return findElement;
	}

	public List<WebElement> findLocatorByTagNameList(String tagName) {

		List<WebElement> findElements = driver.findElements(By.tagName(tagName));
		for (WebElement e : findElements) {
			String text = e.getText();
			System.out.println(text);
		}
		return findElements;
	}

	public List<WebElement> findLocatorByXpathList(String xpathExp) {
		List<WebElement> findElements = driver.findElements(By.xpath(xpathExp));
		for (WebElement x : findElements) {
			String text = x.getText();
			System.out.println(text);
		}

		return findElements;

	}

	public String getApplnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean elementIsEnabled(WebElement element) {
		visiblityOfElement(element);
		boolean enabled = element.isEnabled();
		return enabled;

	}

	public boolean elementIsSelected(WebElement element) {
		visiblityOfElement(element);

		boolean selected = element.isSelected();
		return selected;
	}

	public void elementClearTextBox(WebElement element) {
		visiblityOfElement(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.clear();
		}
	}
	
	

	public String elementGetText(WebElement element) {
		String text = null;
		if (elementIsDisplayed(element)) {
			text = element.getText();
		}
		return text;
	}

	// 99--->Value is fixed
	public String elementGetDomProperty(WebElement element) {
		String domProperty = null;
		visiblityOfElement(element);
		if (elementIsDisplayed(element)) {
			domProperty = element.getDomProperty("value");
		}
		return domProperty;
	}

	// 1--->?
	public String elementGetDomProperty(WebElement element, String attributeName) {
		visiblityOfElement(element);
		String domProperty = null;
		if (elementIsDisplayed(element)) {
			domProperty = element.getDomProperty(attributeName);
		}
		return domProperty;

	}

	public void selectOptionByText(WebElement element, String text) {
		visiblityOfElement(element);
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByValue(WebElement element, String value) {
		visiblityOfElement(element);
		select = new Select(element);
		select.selectByValue(value);
		;
	}

	public void selectOptionByindex(WebElement element, int index) {
		visiblityOfElement(element);
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void urlNavigate(String url) {
		driver.navigate().to(url);
	}

	public void fNavigate() {
		driver.navigate().forward();
	}

	public void bNavigate() {
		driver.navigate().back();
	}

	public void rNavigate() {
		driver.navigate().refresh();
	}

	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByFrameIdorName(WebElement iframe) {
		driver.switchTo().frame(iframe);
	}

	public void switchToFrameByWebelement(WebElement element) {

		driver.switchTo().frame(element);
	}

	public void switchBackToWindow(WebElement element) {
		driver.switchTo().defaultContent();

	}
}

	
	


