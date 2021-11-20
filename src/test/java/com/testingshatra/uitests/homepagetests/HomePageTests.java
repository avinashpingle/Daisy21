package com.testingshatra.uitests.homepagetests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.pages.HomePage;
//ThreadLocal

/**
 * 
 * @author satish
 *
 */

public class HomePageTests extends BaseClass {
	String expectedTitle = "Testing Shastra | Training | Placement";
	UIKeywords keyword = UIKeywords.getInstance();

	@Test
	public void verifyTitleOfHomePage() {
		String title = keyword.getTitleOfPage();
		AssertJUnit.assertEquals(title, expectedTitle);
	}

	@Test
	public void validateAllLinksOfHomePage() throws IOException {
		HomePage home = new HomePage();
		List<WebElement> links = home.getAllLinks();
		Iterator<WebElement> itr = links.iterator();
		while (itr.hasNext()) {
			String url = itr.next().getAttribute("href");
			try {
				HttpsURLConnection con = (HttpsURLConnection) (new URL(url).openConnection());
				int code = con.getResponseCode();
				System.out.println("Url: "+url+" Status Code: "+code);
				Assert.assertFalse(code>400,"Link is broken: " + url);
			} catch (MalformedURLException e) {
				System.out.println("Url: " + url);
			}

		}
	}
}
