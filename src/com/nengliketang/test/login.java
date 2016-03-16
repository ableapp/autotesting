package com.nengliketang.test;


import java.util.Random;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.app.test.Publicclass;

public class login extends UiAutomatorTestCase {
	/*
	 * 注册是否都能注册成功并自动登录
	 */
	public void testregister(){
		new Publicclass().findablesky();
		new Publicclass().clickMy();
		new Publicclass().clickLoginAndRegistButton();
		new Publicclass().clickregisterButton();
		//用户名、邮箱、密码
		UiObject email=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/register_edt_email"));
		UiObject username=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/register_edt_username"));
		UiObject passport=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/register_edt_password"));
		//点击注册
		UiObject register=new UiObject(new UiSelector().text("注册"));
		//随机数5位
		int rand1=new Random().nextInt(9);
		int rand2=new Random().nextInt(9);
		int rand3=new Random().nextInt(9);
		int rand4=new Random().nextInt(9);
		int rand5=new Random().nextInt(9);
		int rand=rand1*10000+rand2*1000+rand3*100+rand4*10+rand5;
		String emailtext="test"+rand+"@163.com";
		String usernametext="test"+rand+"2016";
		
		try {
			email.clearTextField();
			email.setText(emailtext);
			username.clearTextField();
			username.setText(usernametext);
			passport.clearTextField();
			passport.setText("aaaa");
			register.click();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		sleep(1000);
		new Publicclass().clickSettings();
		new Publicclass().clickLogout();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
	}
	
	
	public void testlogin() {
		new Publicclass().findablesky();
		new Publicclass().clickMy();
		new Publicclass().clickLoginAndRegistButton();
		new Publicclass().inputUser("zidonghuaceshi");
		new Publicclass().inputPassport("aaaa");
		new Publicclass().clickLoginButton();
		assertTrue(new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/username")).exists());
	}

}
