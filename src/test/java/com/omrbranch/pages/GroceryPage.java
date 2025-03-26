package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.baseclass.BaseClass;

public class GroceryPage extends BaseClass{
	
	public GroceryPage() {
		 
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//h3[text()='Grocery']")
	private WebElement clkGrocery;
	
	@FindBy(id = "search")
	private WebElement txtSearch;
	
	 public void grocery() {
    	 elementClick(clkGrocery);
     }
	 
	 public void productName(String productName) {
			elementSendKeysEnter(txtSearch, productName);

		}

}
