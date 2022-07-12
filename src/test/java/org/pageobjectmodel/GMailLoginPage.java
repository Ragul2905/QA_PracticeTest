package org.pageobjectmodel;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GMailLoginPage extends BaseClass{
	
	public GMailLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "identifierId")
	private WebElement userEmail;

	@FindBy(name = "password")
	private WebElement userPassword;
	
	@FindBy(xpath = "//span[text() = 'Next']")
	private WebElement nxtBtn;

	@FindBy(xpath = "//span[contains(text(),'Wrong password')]")
	private WebElement txtWrongPass;

	@FindBy(xpath = "//div[contains(text(), 'valid email')]")
	private WebElement txtInvalidEmail;
	
	@FindBy(xpath = "//a[@class='gb_A gb_La gb_f']")
	private WebElement profIcon;

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public WebElement getNxtBtn() {
		return nxtBtn;
	}

	public WebElement getTxtWrongPass() {
		return txtWrongPass;
	}

	public WebElement getTxtInvalidEmail() {
		return txtInvalidEmail;
	}

	public WebElement getProfIcon() {
		return profIcon;
	}
	
	
	


}
