package org.pageobjectmodel;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseClass{
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "prcIsum")
	private WebElement Price;

	public WebElement getPrice() {
		return Price;
	}


}
