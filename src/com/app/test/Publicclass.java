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
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressMenu();
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
	 * 点击我的页面的登录/注册
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
			name.clearTextField();
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
	 * 点击用户登录页面的登录按钮
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
	
	/**
	 * 点击我的页面的我的收藏
	 */
	public void clickCollection(){
		UiObject collection=new UiObject(new UiSelector().text("我的收藏"));
		try {
			sleep(1000);
			collection.click();
			sleep(1000);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * 课程详情页面收藏
	 */
	public void collectionOk(){
		UiObject collect=new UiObject(new UiSelector().textStartsWith("收藏"));
		UiObject collect1=new UiObject(new UiSelector().textStartsWith("已收藏"));
		if(collect1.exists()){
			collectionCansel();
			collectionOk();
		}	
		else{
			sleep(1000);
			try {
				collect.click();
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}
			sleep(1000);
		}
		assertTrue(collect1.exists());
	}
	
	/**
	 * 课程详情页面取消收藏
	 */
	public void collectionCansel(){
		UiObject collect=new UiObject(new UiSelector().textStartsWith("已收藏"));
		UiObject collect1=new UiObject(new UiSelector().textStartsWith("收藏"));
		if(collect1.exists()){
			collectionOk();
			collectionCansel();
		}	
		else{
			sleep(1000);
			try {
				collect.click();
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}
			sleep(1000);
		}
		assertTrue(collect1.exists());
	}
	
	/**
	 * 点击返回
	 */
	public void clickBack(){
		UiObject back=new UiObject(new UiSelector().textStartsWith("返回"));
		try {
			sleep(1000);
			back.click();
			sleep(1000);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
	}
}
