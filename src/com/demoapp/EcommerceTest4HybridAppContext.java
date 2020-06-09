package com.demoapp;

import java.net.MalformedURLException;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class EcommerceTest4HybridAppContext extends EcommerceBase {
	
	
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
		
		
		
		//Mobile Gesture
		
		
	WebElement  checkbox=driver.findElement(By.className("android.widget.CheckBox"));
	TouchAction t=new TouchAction(driver);
	t.tap(tapOptions().withElement(element(checkbox))).perform();
	
	
	WebElement button=driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
	t.tap(tapOptions().withElement(element(button))).perform();
	
	Thread.sleep(7000);
	
	Set<String> contexts=driver.getContextHandles();
	
	for(String contextName :contexts) 
	{
		
		System.out.println(contextName);
	}
	
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		Thread.sleep(6000);
		driver.findElement(By.name("q")).sendKeys("hello");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));http://dl.bintray.com/testng-team/testng-eclipse-release/.http://dl.bintray.com/testng-team/testng-eclipse-release/. http://dl.bintray.com/testng-team/testng-eclipse-release/.
		driver.context("NATIVE_APP");
		
		

	}
	
	

}
