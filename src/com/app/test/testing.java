package com.app.test;

import com.app.test.UiAutomatorHelper;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class testing extends UiAutomatorTestCase {

	public static void main(String[] args){
		String jarName = "test";
		// ²âÊÔÄÜÁ¦¿ÎÌÃ
		String testClass = "com.nengliketang.test.login";
		String testName = "";
		String androidId = "10";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}
}
