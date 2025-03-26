package com.omrbranch.pages;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.baseclass.BaseClass;

public class AddressPage extends BaseClass {
	
	public AddressPage() {
		 
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[@data-target='#addressModal']")
	private WebElement btnAddress;
	
	@FindBy(xpath = "//select[@name='address_type']")
	private WebElement ddnAddressType;
	
//	@FindBy(id = "address_type")
//	private WebElement ddnAddressType;
	
	@FindBy(xpath = "//option[@value='Home']")
	private WebElement clkHome;
//	
//	@FindBy(name="(//input[@name='first_name'])[1]")
//	private WebElement txtName;
	
	
	@FindBy(name="first_name")
	private WebElement txtName;
	
	@FindBy(name="last_name")
	private WebElement txtLastName;
	
	@FindBy(name="mobile")
	private WebElement txtMobile;
	
	@FindBy(name="apartment")
	private WebElement txtapartment;
	
	@FindBy(name="address")
	private WebElement txtAddress;
	
	@FindBy(name="state")
	private WebElement ddnState;
	
	@FindBy(xpath = "//option[text()='Andhra Pradesh']")
	private WebElement clkAndra;
	
	@FindBy(name = "city")
	private WebElement ddnCity;
	
	@FindBy(name = "//select[@name='country']")
	private WebElement ddnCountry;
	
	@FindBy(xpath = "//option[text()='Tirupati']")
	private WebElement clkTirupati;
	
	@FindBy(name="zipcode")
	private WebElement txtZipcode;
	
	@FindBy(xpath = "//button[@class='saveAddress font18 fontSemiBold colorWhite bgTheme radius50 borderNone px-5 py-2 hover1']")
	private WebElement btnSave;
	
	public void addAddress(String firstName, String lastName, String mobile, String apartment, String state, String city, String country,String zipcode, String address,String address_type) throws InterruptedException {
		
		elementClick(btnAddress);
		
		Thread.sleep(3000);
		selectOptionByValue(ddnAddressType, address_type);
		//selectOptionByText(ddnAddressType, address_type);
		//selectOptionByText(clkHome, addressType);
		elementSendKeys(txtName, firstName);
		elementSendKeys(txtLastName, lastName);
		elementSendKeys(txtMobile, mobile);
		elementSendKeys(txtapartment, apartment);
//		elementClick(ddnState);
		selectOptionByText(ddnState, state);
//		elementClick(ddnCity);
		selectOptionByText(ddnCity, city);
//		selectOptionByText(ddnCountry, country);
		elementSendKeys(txtZipcode, zipcode);
		elementSendKeys(txtAddress, address);
		
		
		//selectOptionByText(btnAddress, addressType);

		
	
		elementClick(btnSave);
		

	}
	
	
	
	
	
	

}
