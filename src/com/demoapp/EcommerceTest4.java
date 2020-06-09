package com.demoapp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class EcommerceTest4 extends EcommerceBase {
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		//click dropdown button/scroll till value//click on value
		driver.findElementById("android:id/text1").click();
		                                                                                                                                                          //PutAnyTextHere
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText +"\").instance(0))"));
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));");
		driver.findElementByXPath("//*[@text='Aruba']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(4000);
		
		String amount1=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		//$120.0
		//remove $ sign before amount
		amount1 = amount1.substring(1);
		//120.0
		double amount1value=Double.parseDouble(amount1);    //convert String into Double
		
		String amount2=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
		//$160.97
		
		amount2=amount2.substring(1);
		//160.97
		double amount2value=Double.parseDouble(amount2);  //convert String into Double
		
		double sumOfProducts=amount1value+amount2value;
		
		System.out.println(sumOfProducts+"sum of products");
		
		String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		total = total.substring(1);
		
		double totalValue=Double.parseDouble(total);
		
		System.out.println(totalValue+"total value of products");
		
		
		
		//Assert.assertEquals(sumOfProducts, totalValue);
		
		

	}


}
