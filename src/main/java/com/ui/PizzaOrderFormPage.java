package com.ui;

import com.sample.test.pizzaForm.constants.PizzaToppings;
import com.sample.test.pizzaForm.constants.PizzaTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

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

    By creditCardRadioButton = By.cssSelector("#paymentSection #ccpayment");
    By cashOnPickUpRadioButton = By.cssSelector("#paymentSection #cashpayment");
    By placeOrderButton = By.id("placeOrder");
    By resetButton = By.id("reset");

    By popUpText = By.className("ui-dialog-content");
    By closePopUpbutton = By.className("ui-dialog-titlebar-close");

    // Verify text of message in pop-up
    public PizzaOrderFormPage verifyTextInDialog(String popUpMessage){
        assertEquals(popUpMessage, driver.findElement(popUpText).getText());
        return this;
    }
    // Method for clicking by close button on PopUp
    public PizzaOrderFormPage clickByClosePopUpButton(){
        driver.findElement(closePopUpbutton).click();
        return this;
    }
    // Selector method for dropdown Toppings 1 with name of topping as parameter
    public PizzaOrderFormPage selectFromDropDownToppings1(String toppingType){
        Select drop = new Select(driver.findElement(toppings1pizzaDropdownField));
        drop.selectByVisibleText(toppingType);
        return this;
    }

    // Selector method for dropdown Toppings 2 with name of topping as parameter
    public PizzaOrderFormPage selectFromDropDownToppings2(String toppingType){
        Select drop = new Select(driver.findElement(toppings2pizzaDropdownField));
        drop.selectByVisibleText(toppingType);
        return this;
    }

    // Selector method for dropdown Pizza 1 with name of pizza as parameter
    public PizzaOrderFormPage selectFromDropDownPizzaType(String pizzaType){
        Select drop = new Select(driver.findElement(pizzaDropdownField));
        drop.selectByValue(pizzaType);
        return this;
    }
    // Method for setting name field with string parameter
    public PizzaOrderFormPage setNameField(String name){
        driver.findElement(nameInputField).clear();
        driver.findElement(nameInputField).sendKeys(name);
        return this;
    }

    // Method for setting email field with string parameter
    public PizzaOrderFormPage setEmailField(String email){
        driver.findElement(emailInputField).clear();
        driver.findElement(emailInputField).sendKeys(email);
        return this;
    }

    // Method for setting phone field with string parameter
    public PizzaOrderFormPage setPhoneField(String phone){
        driver.findElement(phoneInputField).clear();
        driver.findElement(phoneInputField).sendKeys(phone);
        return this;
    }

    // Method for setting quantity field with integer parameter
    public PizzaOrderFormPage setQuantityField(int quantity){
        driver.findElement(quantityInputField).clear();
        driver.findElement(quantityInputField).sendKeys(String.valueOf(quantity));
        return this;
    }

    // Method for selecting credit card radio button
    public PizzaOrderFormPage selectPayByCreditCard(){
        driver.findElement(creditCardRadioButton).click();
        return this;
    }

    // Method for selecting cash on pick up radio button
    public PizzaOrderFormPage selectPayByCash(){
        driver.findElement(cashOnPickUpRadioButton).click();
        return this;
    }

    // Method for clicking by "Place order" button
    public PizzaOrderFormPage clickOnPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
        return this;
    }

    // Method for clicking by "Reset" button
    public PizzaOrderFormPage clickOnResetButton(){
        driver.findElement(resetButton).click();
        return this;
    }

}
