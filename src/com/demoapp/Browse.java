package com.demoapp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Browse extends BaseCrome {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.mashvirtual.com");
		driver.findElementByXPath("//a[@class='slicknav_btn slicknav_collapsed']").click();
		driver.findElementByXPath("//ul[@class='slicknav_nav']//span[contains(text(),'Projects')]").click();
		
		JavascriptExecutor jse = driver;
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,1800)","");
		
		
		driver.findElementByXPath("//ul[@class='slicknav_nav']//span[contains(text(),'Team')]").click();
		driver.findElementByXPath("//ul[@class='slicknav_nav']//span[contains(text(),'Contact')]").click();
		driver.findElementByXPath("//span[@class='slicknav_icon']//span[2]").click();
		driver.findElementByXPath("//input[@id='name']").sendKeys("Akash");
		driver.findElementByXPath("//input[@id='email']").sendKeys("akash@gmail.com");
		driver.close();
		
		


	}

}
