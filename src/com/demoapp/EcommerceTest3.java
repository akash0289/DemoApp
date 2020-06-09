package com.demoapp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceTest3 extends EcommerceBase {
	public static void main(String[] args) throws MalformedURLException {
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
		
		//To verify new product add in list
		
		//1.First Try print all product id
		
		//System.out.println(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size());
		//Below code first we navigate to the parent then go to the child \\textMatches(\"\") in this method put matching text                                                                                         
		
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"\").instance(0))"));
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		
		//How can we click on "ADD TO CART" while the id is same for all
		
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		//loop is working for all product one by one till it will match with required text
		for(int i=0;i<count;i++) {
			
			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(text.equalsIgnoreCase("Jordan 6 Rings")) {
				
				//If text is match/get count/click on add to cart for that count
				
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				
				break;//we do not need to go for more iteration
			}
				
				
			
			}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		String lastpageText=  driver.findElement(By.xpath("//android.widget.TextView[@text='Jordan 6 Rings']")).getText();
		
		//Error with this code
		//String lastpageText =  driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		
		

		Assert.assertEquals("Jordan 6 Rings", lastpageText);
		System.out.println(lastpageText);
		
		
		
		

	}


}
