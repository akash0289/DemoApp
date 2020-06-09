package com.demoapp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class BrowseCricbuzz extends BaseCrome {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cricbuzz.com");
		driver.findElementByXPath("//span[contains(text(),'Menu')]").click();
		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
		//System.out.println(driver.getCurrentUrl());
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,480)","");
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));
		
		//driver.close();
		
		


	}

}
