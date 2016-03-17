package com.nengliketang.test;


import java.util.Random;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
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
			if(new UiObject(new UiSelector().text("用户注册")).exists()){
				UiDevice.getInstance().pressBack();
				register.click();
			}				
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		sleep(1000);
		new Publicclass().clickSettings();
		new Publicclass().clickLogout();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
	}
	
	/*
	 * 内训账号不能登录能力课堂
	 */
	public void testlogin() {
		new Publicclass().findablesky();
		new Publicclass().clickMy();
		new Publicclass().clickLoginAndRegistButton();
		new Publicclass().inputUser("duyonghong*as");
		new Publicclass().inputPassport("duyonghong12");
		new Publicclass().clickLoginButton();
		assertTrue(new UiObject(new UiSelector().text("用户登录")).exists());
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
	}
	
	/*
	 * 机构管理员可以登录能力课堂
	 */
	public void testAdminLogin(){
		new Publicclass().findablesky();
		new Publicclass().clickMy();
		new Publicclass().clickLoginAndRegistButton();
		new Publicclass().inputUser("astest-du");
		new Publicclass().inputPassport("dyh123");
		new Publicclass().clickLoginButton();
		new Publicclass().clickSettings();
		new Publicclass().clickLogout();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
	}
	
	/*
	 * 我的收藏夹上拉下拉，收藏课程、取消收藏
	 */
	public void testcollection(){
		new Publicclass().findablesky();
		new Publicclass().clickMy();
		new Publicclass().clickLoginAndRegistButton();
		new Publicclass().inputUser("zidonghuaceshi");
		new Publicclass().inputPassport("aaaa");
		new Publicclass().clickLoginButton();
		//收藏2个首页的课程
		new Publicclass().clickHomePage();
		UiObject course1=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/tuijian1"));
		UiObject course2=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/tuijian2"));
		UiObject coursename1=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/tujianname1"));
		UiObject coursename2=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/tujianname2"));
		String name1="";
		String name2="";
		try {
			name1=coursename1.getText();
			name2=coursename2.getText();
			course1.click();
			new Publicclass().collectionOk();
			new Publicclass().clickBack();
			course2.click();
			new Publicclass().collectionOk();
			new Publicclass().clickBack();		
		} catch (UiObjectNotFoundException e1) {
			e1.printStackTrace();
		}
		new Publicclass().clickMy();
		new Publicclass().clickCollection();
		//收藏列表上下滑动
		UiScrollable cList=new UiScrollable(new UiSelector().resourceId("com.ablesky.ui.activity:id/shoucangjialist"));
		try {
			cList.scrollForward();
			cList.scrollForward();
			sleep(1000);
			cList.scrollBackward();
			cList.scrollBackward();
			sleep(1000);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		//删除新收藏的两个课程
		UiObject collect1=new UiObject(new UiSelector().text(name1));
		UiObject collect2=new UiObject(new UiSelector().text(name2));
		UiObject delete=new UiObject(new UiSelector().text("删 除"));
		try {
			collect1.swipeLeft(10);
			sleep(1000);
			delete.click();
			sleep(1000);
			collect2.swipeLeft(10);
			sleep(1000);
			delete.click();
			sleep(1000);
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		assertTrue(!(collect1.exists()&&collect2.exists()));
		new Publicclass().clickBack();
		new Publicclass().clickSettings();
		new Publicclass().clickLogout();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
	}
	
	/*
	 * 访客收藏的课程，登录后是否能进入用户的我的
	 */
	public void nologinCollection(){
		new Publicclass().findablesky();
		new Publicclass().clickHomePage();
		UiObject course1=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/tuijian1"));
		UiObject coursename1=new UiObject(new UiSelector().resourceId("com.ablesky.ui.activity:id/tujianname1"));
		String name1="";
		try {
			name1=coursename1.getText();
			course1.click();
			new Publicclass().collectionOk();
			new Publicclass().clickBack();		
		} catch (UiObjectNotFoundException e1) {
			e1.printStackTrace();
		}
		new Publicclass().clickMy();
		new Publicclass().clickLoginAndRegistButton();
		new Publicclass().inputUser("zidonghuaceshi");
		new Publicclass().inputPassport("aaaa");
		new Publicclass().clickLoginButton();
		new Publicclass().clickCollection();
		UiObject collect1=new UiObject(new UiSelector().text(name1));
		assertTrue(collect1.exists());
		new Publicclass().clickBack();
		new Publicclass().clickSettings();
		new Publicclass().clickLogout();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
	}

}
