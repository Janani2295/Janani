package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.baseclass.BaseClass;

import io.cucumber.datatable.DataTable;

public class PaymentPage extends BaseClass{
	String cardNo;
	String cardMonth;
	String cardYear;
	String cvv;
	
	public PaymentPage()  {
		 
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="payment_type")
	private WebElement ddnPaymentType;
	
	@FindBy(xpath = "//option[text()=' Debit Card ']")
	private WebElement clkDebit;
	
	@FindBy(xpath = "//label[text()=' Visa ']")
	private WebElement clkVisa;
	
	@FindBy(name = "card_no")
	private WebElement txtCardNo;
	
//	@FindBy(id = "month")
//	private WebElement ddnMonth;
//	
//	@FindBy(xpath = "//option[text()= 'February']")
//	private WebElement clkFeb;
	
	@FindBy(id = "month")
	private WebElement ddnMonth;
	
	@FindBy(id = "year")
	private WebElement ddnYear;
	
	@FindBy(xpath = "//option[text()=' 2028 ']")
	private WebElement clkYear;
	
	@FindBy(name = "cvv")
	private WebElement txtCvv;
	
	@FindBy(id = "placeOrder")
	private WebElement btnPlaceOrder;
	
	
	public void paymentMethod(String cardType,DataTable dataTable, String selectCard, String cardNo, String cardName, String month, String year, String cvv) throws InterruptedException {
		
		Thread.sleep(1000);
		selectOptionByValue(ddnPaymentType, cardType);
		elementClick(clkVisa);
		elementSendKeys(txtCardNo, cardNo);
		//elementClick(clkFeb);
		selectOptionByValue(ddnMonth, month);
//		elementClick(ddnYear);
		selectOptionByText(ddnYear, year);
		elementSendKeys(txtCvv, cvv);
		Thread.sleep(1000);
		elementClick(btnPlaceOrder);
		
	}
		
	
		

	}
	


