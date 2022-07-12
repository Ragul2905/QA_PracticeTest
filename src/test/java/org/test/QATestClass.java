package org.test;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.pageobjectmodel.EbayHomePage;
import org.pageobjectmodel.GMailLoginPage;
import org.pageobjectmodel.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QATestClass extends BaseClass {

	@DataProvider(name = "credentials")
	public Object[][] dpMethod() {
		return new Object[][] { { "ragule19@gmail.com", "Time@2810$", "Valid Scenario" }, { "@ragule19@gmail.com", "Time@2810$", "invalid Email"},
				{ "ragule19@gmail.com", "Ti#me@2810$", "Incorrect password" } };
	}

	@BeforeMethod
	private void browserLaunch() {
		launchBrowser();
		maximizeWindow();
		waitforExecution();
	}

	@Test()
	private void testeBay() throws InterruptedException, IOException {
		launchurl("https://www.ebay.com/");
		EbayHomePage home = new EbayHomePage();
		fillTextBox(home.getSearchTextBox(), "Electric Guitar");
		btnClick(home.getSearch());
		btnClick(home.getFirstProduct());
		windowHandles(1);
		ProductPage product = new ProductPage();
		System.out.println("Product Price: "+getText(product.getPrice()));
		screenShot("Product Price");
	}

	@Test(dataProvider = "credentials")
	private void testGmail(String email, String password, String scenario) throws InterruptedException, IOException {
		launchurl("https://www.gmail.com/");

		GMailLoginPage login = new GMailLoginPage();

		fillTextBox(login.getUserEmail(), email);
		btnClick(login.getNxtBtn());
		
		try {
			explicitWaitVis(login.getUserPassword());
			fillTextBox(login.getUserPassword(), password);
			btnClick(login.getNxtBtn());
			
			try {
				Assert.assertTrue(login.getProfIcon().isDisplayed());
				System.out.println("Sucessful login");
				screenShot(scenario);

			} catch (Exception e) {
				Assert.assertTrue(login.getTxtWrongPass().isDisplayed());
				System.out.println("Incorrect Password");
				screenShot(scenario);
				
			}
		} catch (Exception e) {
			Assert.assertTrue(login.getTxtInvalidEmail().isDisplayed());
			System.out.println("Incorrect Email ID");
			screenShot(scenario);
			
		}

	}

	@AfterMethod
	private void aftermethod() {
		browserQuit();
	}

}
