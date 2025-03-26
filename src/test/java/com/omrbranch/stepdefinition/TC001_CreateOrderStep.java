package com.omrbranch.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pageManager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TC001_CreateOrderStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	

	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage() {
		
		browserLaunch();
		enterApplnUrl("https://omrbranch.com/");
		maximizeWindow();
	    
	}
	@When("User should login {string},{string}")
	public void userShouldLogin(String userName, String password) {
		pom.getLogin().login(userName,password);
	
		
	   	}
	
	@Then("User should verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String string) {
		 impliciwait();
	   String loginMessage = pom.getLogin().loginMessage();
		System.out.println(loginMessage);

	    	}



	@When("User enter search keyword {string} for product")
	public void userEnterSearchKeywordForProduct(String product) {
		pom.getGroceryPage().grocery();
	
		pom.getGroceryPage().productName(product);
	   	}
	@When("User select the product name contains {string} from the product list")
	public void userSelectTheProductNameContainsFromTheProductList(String product) {
		pom.getSelectProduct().selectProduct();
	    	}
	@When("User added the product to cart")
	public void userAddedTheProductToCart() throws InterruptedException {
		pom.getSelectProduct().addToCart();
	    	}
	@When("User add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},and {string}")
	public void userAddNewAddressAnd(String firstName, String lastName, String mobile, String apartment, String state, String city, String country, String zipcode, String address,String address_type) throws InterruptedException {
		
		pom.getAddress().addAddress(firstName, lastName, mobile, apartment, state, city, country, zipcode, address,address_type);
		
		
		//pom.getAddress().addAddress(addressType,firstName, lastName, mobile, apartment, state, city, "101", zipcode, address);		
	    	}
	@When("User enter payment details, procced with card type {string}")
	public void userEnterPaymentDetailsProccedWithCardType(String cardType, io.cucumber.datatable.DataTable dataTable) throws InterruptedException
	{
		
		List<Map<String,String>> maps = dataTable.asMaps();
	   	 Map<String, String> map = maps.get(0);
	   	 String selectCard = map.get("Select Card");
	   	 String cardNo = map.get("CardNo");
	   	 String cardName = map.get("CardName");
	   	 String month = map.get("Month");
	   	 String year = map.get("Year");
	   	 String cvv = map.get("CVV");
	   	pom.getPayment().paymentMethod(cardType, dataTable, selectCard, cardNo, cardName, month, year,cvv);
	   
	   	
	   	}
	@Then("User should verify order placed success message contains {string} and save Order number")
	public void userShouldVerifyOrderPlacedSuccessMessageContainsAndSaveOrderNumber(String expSuccessMessage) {
		
	   	}
	
	
	






}
