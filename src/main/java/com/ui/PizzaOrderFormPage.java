package com.ui;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;
@Getter
public class PizzaOrderFormPage {

    WebDriver driver;

    public PizzaOrderFormPage(WebDriver driver) {
        this.driver = driver;
    }


    // Below described elements on the page Pizza Order Form
    By pizzaDropdownField = By.id("pizza1Pizza");
    By toppings1pizzaDropdownField = By.className("toppings1");
    By toppings2pizzaDropdownField = By.className("toppings2");
    By quantityInputField = By.cssSelector("#pizza1 #pizza1Qty");
    By nameInputField = By.id("name");
    By emailInputField = By.id("email");
    By phoneInputField = By.id("phone");
    By creditCardRadioButton = By.cssSelector("#paymentSection #ccpayment");
    By cashOnPickUpRadioButton = By.cssSelector("#paymentSection #cashpayment");
    By placeOrderButton = By.id("placeOrder");
    By resetButton = By.id("reset");
    By popUpText = By.className("ui-dialog-content");
    By closePopUpButton = By.className("ui-dialog-titlebar-close");

    // Method for comparing field value with provided constant text
    @Step("Compare given value: {0} with given constant: {1}")
    public PizzaOrderFormPage compareCurrentFieldValueWith(String constant, String currentFieldValue){
        assertEquals(constant, currentFieldValue);
        return this;
    }
    // General method to check current selected value in the dropdown
    @Step("Get current value of the element in the dropdown for provided element: {0}")
    public String getCurrentValueOfDropDownByElementName(By element){
        Select drop = new Select(driver.findElement(element));
        return drop.getFirstSelectedOption().getText();
    }
    // Get current value of pizza dropdown field
    @Step("Get current value of pizza dropdown element")
    public String getCurrentValuePizzaDropDown(){
        return getCurrentValueOfDropDownByElementName(pizzaDropdownField);
    }
    // Get current value of toppings 1 dropdown field
    @Step("Get current value of toppings1 dropdown element")
    public String getCurrentValueToppings1DropDown(){
        return getCurrentValueOfDropDownByElementName(toppings1pizzaDropdownField);
    }
    // Get current value of toppings 2 dropdown field
    @Step("Get current value of toppings2 dropdown element")
    public String getCurrentValueToppings2DropDown(){
        return getCurrentValueOfDropDownByElementName(toppings2pizzaDropdownField);
    }
    // Verify text of message in pop-up
    @Step("Compare text of message in the pop-up with provided constant: {0}")
    public PizzaOrderFormPage verifyTextInDialog(String popUpMessage){
        assertEquals(popUpMessage, driver.findElement(popUpText).getText());
        return this;
    }
    // Method for clicking by close button on PopUp
    @Step("Click by close button in the pop-up")
    public PizzaOrderFormPage clickByClosePopUpButton(){
        driver.findElement(closePopUpButton).click();
        return this;
    }
    // Condition for popup closing in AfterMethod
    @Step("Condition: if pop-up displayed - close by clicking close button")
    public void
    closePopUpIfDisplayed(){
        if (driver.findElement(closePopUpButton).isDisplayed()){
            clickByClosePopUpButton();
        }
    }
    // Selector method for dropdown Toppings 1 with name of topping as parameter
    @Step("Select item from topping1 dropdown by provided topping type: {0}")
    public PizzaOrderFormPage selectFromDropDownToppings1(String toppingType){
        Select drop = new Select(driver.findElement(toppings1pizzaDropdownField));
        drop.selectByVisibleText(toppingType);
        return this;
    }
    // Selector method for dropdown Toppings 2 with name of topping as parameter
    @Step("Select item from topping2 dropdown by provided topping type: {0}")
    public PizzaOrderFormPage selectFromDropDownToppings2(String toppingType){
        Select drop = new Select(driver.findElement(toppings2pizzaDropdownField));
        drop.selectByVisibleText(toppingType);
        return this;
    }
    // Selector method for dropdown Pizza 1 with name of pizza as parameter
    @Step("Select item from pizza type dropdown by provided pizza type: {0}")
    public PizzaOrderFormPage selectFromDropDownPizzaType(String pizzaType){
        Select drop = new Select(driver.findElement(pizzaDropdownField));
        drop.selectByValue(pizzaType);
        return this;
    }
    // Method for setting name field with string parameter
    @Step("Set name field by provided name: {0} as a parameter")
    public PizzaOrderFormPage setNameField(String name){
        driver.findElement(nameInputField).clear();
        driver.findElement(nameInputField).sendKeys(name);
        return this;
    }
    // Method for setting email field with string parameter
    @Step("Set email field by provided value: {0} as a parameter")
    public PizzaOrderFormPage setEmailField(String email){
        driver.findElement(emailInputField).clear();
        driver.findElement(emailInputField).sendKeys(email);
        return this;
    }
    // Method for setting phone field with string parameter
    @Step("Set phone field by provided string value: {0} as a parameter")
    public PizzaOrderFormPage setPhoneField(String phone){
        driver.findElement(phoneInputField).clear();
        driver.findElement(phoneInputField).sendKeys(phone);
        return this;
    }
    // Method for setting quantity field with integer parameter
    @Step("Set phone field by provided integer value: {0} as a parameter")
    public PizzaOrderFormPage setQuantityField(int quantity){
        driver.findElement(quantityInputField).clear();
        driver.findElement(quantityInputField).sendKeys(String.valueOf(quantity));
        return this;
    }
    // Method for setting quantity field with String parameter
    @Step("Set quantity field by provided string value: {0} as a parameter")
    public PizzaOrderFormPage setQuantityField(String quantity){
        driver.findElement(quantityInputField).clear();
        driver.findElement(quantityInputField).sendKeys(quantity);
        return this;
    }
    // Method for setting quantity field with double parameter
    @Step("Set quantity field by provided double value: {0} as a parameter")
    public PizzaOrderFormPage setQuantityField(double quantity){
        driver.findElement(quantityInputField).clear();
        driver.findElement(quantityInputField).sendKeys(String.valueOf(quantity));
        return this;
    }
    // Method for selecting credit card radio button
    @Step("Click by credit card radio button")
    public PizzaOrderFormPage selectPayByCreditCard(){
        driver.findElement(creditCardRadioButton).click();
        return this;
    }
    // Method for selecting cash on pick up radio button
    @Step("Click by cas on pickup radio button")
    public PizzaOrderFormPage selectPayByCash(){
        driver.findElement(cashOnPickUpRadioButton).click();
        return this;
    }
    // Method for clicking by "Place order" button
    @Step("Click by place order button")
    public PizzaOrderFormPage clickOnPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
        return this;
    }
    // Method for clicking by "Reset" button
    @Step("Click by reset button")
    public PizzaOrderFormPage clickOnResetButton(){
        driver.findElement(resetButton).click();
        return this;
    }
}
