package com.demoapp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceTest2 extends EcommerceBase {
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		//driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		//click dropdown button/scroll till value//click on value
		driver.findElementById("android:id/text1").click();
		                                                                                                                                                          //PutAnyTextHere
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText +"\").instance(0))"));
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));");
		driver.findElementByXPath("//*[@text='Canada']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String toastMessage=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		
		System.out.println(toastMessage);
		Assert.assertEquals("Please enter your name", toastMessage);//Actual Validation
		
		
		

	}


}
