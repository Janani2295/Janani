package com.omrbranch.pageManager;

import com.omrbranch.pages.AddressPage;
import com.omrbranch.pages.GroceryPage;
import com.omrbranch.pages.LoginPage;
import com.omrbranch.pages.PaymentPage;
import com.omrbranch.pages.SearchProductPage;
import com.omrbranch.pages.SelectProductPage;

public class PageObjectManager {
	private LoginPage loginPage;
	private SearchProductPage searchProductPage;
	private SelectProductPage selectProductPage;
	private AddressPage addressPage;
	private PaymentPage paymentPage;
	private GroceryPage groceryPage;
	
	public LoginPage getLogin() {
		return (loginPage==null)?loginPage=new LoginPage():loginPage;
		
	}
	public GroceryPage getGroceryPage() {
		return (groceryPage==null)?groceryPage=new GroceryPage():groceryPage;
		
	}
	public SelectProductPage getSelectProduct() {
		return (selectProductPage==null)?selectProductPage=new SelectProductPage():selectProductPage;
		
	}
	public SearchProductPage getSearchProduct() {
		return (searchProductPage==null)?searchProductPage=new SearchProductPage():searchProductPage;
		
		
	}
	public AddressPage getAddress() {
		return (addressPage==null)?addressPage=new AddressPage():addressPage;
		
		
	}
	
	public PaymentPage getPayment() {
		return (paymentPage==null)?paymentPage=new PaymentPage():paymentPage;
		
	}
	

}
