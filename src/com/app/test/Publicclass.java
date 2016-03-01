package com.app.test;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Publicclass extends UiAutomatorTestCase {
	//唤醒手机屏幕，当手机处于解屏状态时不做任何操作；当手机处于锁屏状态时解屏
	public static void wakeUp() {
		try{
			if(!UiDevice.getInstance().isScreenOn())
				UiDevice.getInstance().wakeUp();
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
				
	}
	//滑动解锁，判断手机屏幕是否显示滑动屏幕以解锁，如果显示则滑动屏幕解锁
	public static void slideUnlock(){
		UiObject slideText=new UiObject(new UiSelector().text("滑动屏幕以解锁"));
		int startX = 0;
		int startY = 0;
		int endX = 0;
		int endY = 0;
		try {
			startX = slideText.getBounds().centerX();
			startY = slideText.getBounds().top;
			endX = slideText.getBounds().centerX();
			endY = UiDevice.getInstance().getDisplayHeight()/2;
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}	
		UiDevice.getInstance().swipe(startX, startY, endX, endY, 10);
	}

}
