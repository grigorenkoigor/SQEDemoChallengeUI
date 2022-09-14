package com.ui.pizzaForm;

import com.sample.test.pizzaForm.TestBase;
import com.sample.test.pizzaForm.constants.PizzaToppings;
import com.sample.test.pizzaForm.constants.PizzaTypes;
import com.sample.test.pizzaForm.utilits.PizzaDataProvider;
import com.ui.PizzaOrderFormPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.sample.test.pizzaForm.utilits.DataGenerator.*;
import static org.testng.Assert.assertEquals;


public class PizzaOrderFormPageTests extends TestBase {
    String pizzaName = PizzaTypes.LARGE_THREETOPPINGS.getDisplayName();
    double pizzaCost = PizzaTypes.LARGE_THREETOPPINGS.getCost();
    String topping1 = PizzaToppings.EXTRACHEESE.getDisplayName();
    String topping2 = PizzaToppings.OLIVES.getDisplayName();
    int quantityNumber = 2;

    @AfterMethod
    private void closePopUp(){
        new PizzaOrderFormPage(driver).closePopUpIfDisplayed();
    }


    @Test(description = "Verify happy path for different pizzas with different toppings with paying by credit card ID_1-ID_5",
            dataProvider = "Pizza set", dataProviderClass = PizzaDataProvider.class)
    public void verifyHappyPathWithCreditCard(String pizzaName, String topping1, String topping2,
                                              double pizzaCost, int quantityNumber){
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
                //Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCreditCard()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Thank you for your order! TOTAL: " + pizzaCost*quantityNumber + " " + pizzaName);
    }

    @Test(description = "Verify happy path for different pizzas with different toppings with paying by cash on pick up ID_6-ID_10",
            dataProvider = "Pizza set", dataProviderClass = PizzaDataProvider.class)
    public void verifyHappyPathWithCashOnPickUp(String pizzaName, String topping1, String topping2, double pizzaCost, int quantityNumber){
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
                //Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Thank you for your order! TOTAL: " + pizzaCost*quantityNumber + " " + pizzaName);
    }

    @Test(description = "Verify happy path for different pizzas with different toppings with paying by cash on pick up ID_6-ID_10")
    public void verifyResetButton(){
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);

                // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                // When
                .clickOnResetButton()
                // Then
                .compareCurrentFieldValueWith("Choose Pizza", pizzaOrderPage.getCurrentValuePizzaDropDown())
                .compareCurrentFieldValueWith("Choose a Toppings 1", pizzaOrderPage.getCurrentValueToppings1DropDown())
                .compareCurrentFieldValueWith("Choose a Toppings 2", pizzaOrderPage.getCurrentValueToppings2DropDown())
                .compareCurrentFieldValueWith("", String.valueOf(pizzaOrderPage.getNameInputField()))
                .compareCurrentFieldValueWith("", String.valueOf(pizzaOrderPage.getEmailInputField()))
                .compareCurrentFieldValueWith("", String.valueOf(pizzaOrderPage.getPhoneInputField()));
    }

    @Test(description = "Verify quantity field with negative number")
    public void verifyQuantityFieldWithNegativeNumber() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        int quantityNumber = -3;
                // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Quantity value is incorrect, only possible value - positive integer");
    }

    @Test(description = "Verify quantity field with string")
    public void verifyQuantityFieldWithString() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        String quantityNumber = "fake quantity";
                // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Quantity value is incorrect, only possible value - positive integer");
    }

    @Test(description = "Verify quantity field with zero")
    public void verifyQuantityFieldWithZero() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        int quantityNumber = 0;
                // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Quantity value is incorrect, only possible value - positive integer");
    }

    @Test(description = "Verify quantity with empty field")
    public void verifyQuantityWithEmptyField() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        String quantityNumber = "";
                // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Quantity value is incorrect, only possible value - positive integer");
    }

    @Test(description = "Verify quantity with double value")
    public void verifyQuantityWithDoubleValue() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        double quantityNumber = 3.12345;
                // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Quantity value is incorrect, only possible value - positive integer");
    }

    @Test(description = "Verify name field with empty value")
    public void verifyNameFieldWithEmptyValue() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
                // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField("")
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Missing name");
    }

    @Test(description = "Verify name field with free spaces")
    public void verifyNameFieldWithFreeSpaces() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField("   ")
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Missing name");
    }

    @Test(description = "Verify phone field with empty value")
    public void verifyPhoneFieldWithEmptyValue() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField("")
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Missing phone number");
    }

    @Test(description = "Verify phone field with free spaces value")
    public void verifyPhoneFieldWithFreeSpacesValue() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField("   ")
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Missing phone number");
    }

    @Test(description = "Verify phone field with text")
    public void verifyPhoneFieldWithText() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField("fake phone number")
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("phone number incorrect - please use international phone format like (+380099332211)");
    }

}
