package com.app.test;

import android.os.RemoteException;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Publicclass extends UiAutomatorTestCase {
	
	/**
	 * 唤醒手机屏幕，当手机处于解屏状态时不做任何操作；当手机处于锁屏状态时解屏
	 */
	public static void wakeUp() {
		try{
			if(!UiDevice.getInstance().isScreenOn())
				UiDevice.getInstance().wakeUp();
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
				
	}
	
	/**
	 * 滑动解锁，判断手机屏幕是否显示滑动屏幕以解锁，如果显示则滑动屏幕解锁
	 */
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
			UiDevice.getInstance().swipe(startX, startY, endX, endY, 10);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * 通过滑动定位到能力课堂
	 */
	public void findablesky() {
		UiObject apps=new UiObject(new UiSelector().textContains("应用程序"));
		int startX = UiDevice.getInstance().getDisplayWidth()/2;
		int startY = UiDevice.getInstance().getDisplayHeight()/2;
		int endX = UiDevice.getInstance().getDisplayWidth()/5;
		int endY = UiDevice.getInstance().getDisplayHeight()/2;
		UiObject nlkt=new UiObject(new UiSelector().text("能力课堂"));
		try {
			apps.click();
			sleep(1000);
			for(int i=0;i<10&&!nlkt.exists();i++){
				UiDevice.getInstance().swipe(startX, startY, endX, endY, 10);
			}
			nlkt.click();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 点击“我的”
	 */
	public static void clickMy(){
		UiObject my=new UiObject(new UiSelector().text("我的"));
		try {
			my.click();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 点击登录/注册
	 */
	public static void clickLoginAndRegistButton(){
		UiObject loginAndRegist=new UiObject(new UiSelector().text("登录/注册"));
		try {
			loginAndRegist.click();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 点击用户名框，输入用户名
	 */
	public void inputUser(String user){
		UiCollection edit=new UiCollection(new UiSelector().className("android.widget.EditText"));
		try {
			UiObject name=edit.getChildByInstance(new UiSelector().className("android.widget.EditText"), 0);
			name.clearTextField();
			sleep(1000);
			name.setText(user);
			sleep(1000);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 点击密码框，输入密码
	 */
	public void inputPassport(String passport){
		UiObject pport=new UiObject(new UiSelector().resourceId("login_edt_password"));
			try {
				pport.clearTextField();
				sleep(1000);
				pport.setText(passport);
				sleep(1000);
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}
			
	}

	/**
	 * 点击登录按钮
	 */
	public void clickLoginButton(){
		UiObject pport=new UiObject(new UiSelector().text("登录"));
		try {
			pport.click();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}	
			
	}

}
