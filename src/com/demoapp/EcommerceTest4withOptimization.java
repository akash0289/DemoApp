package com.demoapp;

import java.net.MalformedURLException;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class EcommerceTest4withOptimization extends EcommerceBase {
	
	
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
		
		int count=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sum=0;
		for(int i=0;i<count;i++) {
			
			String amount1=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			double amount=getAmount(amount1);
			sum=sum+amount;
		}
		
		//1st time amount is eg. 1 so sum is 1  ,when i=0;
		//2nd time amount is 2 so sum is 3      ,when i=1;
		//3rd time amount is 4 so sum is 7      ,when i=2;  we are getting all products value i.e. added in cart.
		
		
		System.out.println(sum+"sum of products");
		
		String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		total = total.substring(1);
		
		double totalValue=Double.parseDouble(total);
		
		System.out.println(totalValue+"total value of products");
		
		
		
		//Assert.assertEquals(sumOfProducts, totalValue);
		
		//Mobile Gesture
		
		
	WebElement  checkbox=driver.findElement(By.className("android.widget.CheckBox"));
	TouchAction t=new TouchAction(driver);
	t.tap(tapOptions().withElement(element(checkbox))).perform();
	
	WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
	t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
			
	driver.findElement(By.id("android:id/button1")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	
		
		

	}
	
	public static double getAmount(String value) {
		
		value=value.substring(1);
		double amount2value=Double.parseDouble(value);
		return amount2value;
	}


}
