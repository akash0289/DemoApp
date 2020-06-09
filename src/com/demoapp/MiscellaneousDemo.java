package com.demoapp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.android.AndroidKeyCode;
//import io.appium.java_client.android.nativekey.AndroidKey;

public class MiscellaneousDemo extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.currentActivity());
		System.out.println(driver.getContext());
		//views  -Native, Hybrid, Webview
		
		System.out.println(driver.getOrientation());
		System.out.println(driver.isDeviceLocked());
		//driver.hideKeboard();
	    driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	   //driver.pressKeyCode(AndroidKeyCode.BACK);

	}

	private static AndroidDriver<AndroidElement> capabilities(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
