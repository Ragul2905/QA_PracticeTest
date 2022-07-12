package org.pageobjectmodel;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHomePage extends BaseClass {

	public EbayHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gh-ac")
	private WebElement searchTextBox;

	@FindBy(id = "gh-btn")
	private WebElement search;

	@FindBy(xpath = "(//a[@class='s-item__link'])[2]")
	private WebElement firstProduct;

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getFirstProduct() {
		return firstProduct;
	}

}
