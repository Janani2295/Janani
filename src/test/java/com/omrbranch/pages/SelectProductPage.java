package com.omrbranch.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.baseclass.BaseClass;

public class SelectProductPage extends BaseClass{
	public SelectProductPage() {
		 
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath =  "//a[@class='hover1 font16 fontsemibold colorWhite bgTheme px-4 py-1 radius50 dyna_btn addBtn-18']")
	private WebElement btnProduct;
	
	@FindBy(id = "cart-24")
	private WebElement clkVarient;
	
	@FindBy(xpath = "//a[@class='hover1']")
	private WebElement clkCart;
	
	public void selectProduct() {
		elementClick(btnProduct);
		List<WebElement> products = driver.findElements(By.tagName("h5"));
		for(int i=0;i<products.size();i++) {
			WebElement allProducts = products.get(i);
			String string = allProducts.getText();
			System.out.println(string);
		}
		

}
	
	public void addToCart() throws InterruptedException {
		elementClick(clkVarient);
		Thread.sleep(2000);
		elementClick(clkCart);

	}
	

}
