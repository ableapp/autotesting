package com.nengliketang.test;


import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.app.test.Publicclass;

public class login extends UiAutomatorTestCase {
	public void testlogin() {
		Publicclass.wakeUp();
		Publicclass.slideUnlock();
		new Publicclass().findablesky();
		Publicclass.clickMy();
		Publicclass.clickLoginAndRegistButton();
		new Publicclass().inputUser("zidonghuaceshi");
		new Publicclass().inputPassport("aaaa");
		new Publicclass().clickLoginButton();
	}

}
