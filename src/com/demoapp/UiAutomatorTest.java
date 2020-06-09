package com.demoapp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UiAutomatorTest extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//here we are using UIAutomator
		//driver.findElementByAndroidUIAutomator("property(\"value\")");
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//validate all clickable option
		//driver.findElementsByAndroidUIAutomator("new UiSelector().property(value).click()")
		
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());

	}

}
