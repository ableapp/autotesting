package com.app.test;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Publicclass extends UiAutomatorTestCase {
	
	/**
	 * 通过滑动定位到能力课堂
	 */
	public void findablesky() {
		int startX = UiDevice.getInstance().getDisplayWidth()/2;
		int startY = UiDevice.getInstance().getDisplayHeight()/2;
		int endX = UiDevice.getInstance().getDisplayWidth()/5;
		int endY = UiDevice.getInstance().getDisplayHeight()/2;
		UiObject nlkt=new UiObject(new UiSelector().text("能力课堂"));
		try {
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
	public void clickMy(){
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
	public void clickLoginAndRegistButton(){
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
		UiObject pport=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/login_edt_password"));
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
			sleep(1000);
			pport.click();
			sleep(1000);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}	
			
	}
	
	/**
	 * 点击登录页面的快速注册按钮
	 */
	public void clickregisterButton(){
		UiObject register=new UiObject(new UiSelector().text("快速注册"));
		try {
			sleep(1000);
			register.click();
			sleep(1000);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}	
			
	}
	
	/**
	 * 点击首页
	 */
	public void clickHomePage(){
		UiObject homePage=new UiObject(new UiSelector().text("首页"));
		try {
			sleep(1000);
			homePage.click();
			sleep(1000);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}	
			
	}
	
	/**
	 * 点击我的页面的设置按钮
	 */
	public void clickSettings(){
		UiObject settings=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/setting"));
		try {
			sleep(1000);
			settings.click();
			sleep(1000);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}	
			
	}
	
	/**
	 * 点击设置页面的退出登录
	 */
	public void clickLogout(){
		UiObject logout=new UiObject(new UiSelector().text("退出登录"));
		try {
			sleep(1000);
			logout.click();
			sleep(1000);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}	
			
	}


}
