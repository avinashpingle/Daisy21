package com.testingshatra.uitests;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.testingshastra.config.BaseClass;
import com.testingshastra.keywords.UIKeywords;

public class SignupPageTests extends BaseClass {
	private static final Logger LOG = Logger.getLogger(SignupPageTests.class);
	UIKeywords keyword = UIKeywords.getInstance();

	@Test
	public void validateFullNameFieldForCorrectInput() {

	}
}
