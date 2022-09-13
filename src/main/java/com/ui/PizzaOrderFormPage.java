package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PizzaOrderFormPage {

    WebDriver driver;

    public PizzaOrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    By pizzaDropdownField = By.id("pizza1Pizza");
    By toppings1pizzaDropdownField = By.className("toppings1");
    By toppings2pizzaDropdownField = By.className("toppings2");
    By quantityInputField = By.cssSelector("#pizza1 #pizza1Qty");
    By costInputField = By.className("pizza1Cost");

    By nameInputField = By.id("name");
    By emailInputField = By.id("email");
    By phoneInputField = By.id("phone");

    By creditCardRadioButton = By.id("ccpayment");
    By cashOnPickUpRadioButton = By.id("cashpayment");
    By placeOrderButton = By.id("placeOrder");
    By resetButton = By.id("reset");

    public PizzaOrderFormPage setNameField(String name){
        driver.findElement(nameInputField).clear();
        driver.findElement(nameInputField).sendKeys(name);
        return this;
    }

    public PizzaOrderFormPage setEmailField(String email){
        driver.findElement(emailInputField).clear();
        driver.findElement(emailInputField).sendKeys(email);
        return this;
    }

    public PizzaOrderFormPage setPhoneField(String phone){
        driver.findElement(phoneInputField).clear();
        driver.findElement(phoneInputField).sendKeys(phone);
        return this;
    }

    public PizzaOrderFormPage setQuantityField(int quantity){
        driver.findElement(quantityInputField).clear();
        driver.findElement(quantityInputField).sendKeys(String.valueOf(quantity));
        return this;
    }

}
