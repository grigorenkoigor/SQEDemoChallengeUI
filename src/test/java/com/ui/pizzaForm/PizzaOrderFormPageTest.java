package com.ui.pizzaForm;

import com.sample.test.pizzaForm.TestBase;
import com.sample.test.pizzaForm.constants.PizzaToppings;
import com.sample.test.pizzaForm.constants.PizzaTypes;
import com.sample.test.pizzaForm.utilits.PizzaDataProvider;
import com.sample.test.pizzaForm.utilits.listener.Listener;
import com.ui.PizzaOrderFormPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.sample.test.pizzaForm.utilits.DataGenerator.*;

@Listeners({Listener.class})
public class PizzaOrderFormPageTest extends TestBase {
    String pizzaName = PizzaTypes.LARGE_THREETOPPINGS.getDisplayName();
    double pizzaCost = PizzaTypes.LARGE_THREETOPPINGS.getCost();
    String topping1 = PizzaToppings.EXTRACHEESE.getDisplayName();
    String topping2 = PizzaToppings.OLIVES.getDisplayName();
    int quantityNumber = 3;

    @AfterMethod
    private void closePopUp(){
        new PizzaOrderFormPage(driver).closePopUpIfDisplayed();
    }

    @Test(description = "Verify the intersection of possible pizza parameters happy path with Credit Card - ID_1-ID_5",
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

    @Test(description = "Verify the intersection of possible pizza parameters happy path with Cash on Pickup - ID_6-ID_10",
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

    @Test(description = "Verify Reset button - ID_11")
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

    @Test(description = "Verify Quantity field with negative number - ID_12")
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

    @Test(description = "Verify Quantity field with string value - ID_13")
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

    @Test(description = "Verify Quantity field with value zero - ID_14")
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

    @Test(description = "Verify Quantity field with empty value - ID_15")
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

    @Test(description = "Verify Quantity field with double value - ID_16")
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

    @Test(description = "Verify Quantity field with free spaces value - ID_17")
    public void verifyQuantityWithFreeSpacesValue() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        String quantityNumber = "   ";
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

    @Test(description = "Verify Name field with empty value - ID_18")
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

    @Test(description = "Verify Name field with free spaces value - ID_19")
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

    @Test(description = "Verify Phone field with empty value - ID_20")
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

    @Test(description = "Verify Phone field with free spaces value - ID_21")
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

    @Test(description = "Verify phone field with text - ID_22")
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

    @Test(description = "Verify email field with invalid format - ID_23")
    public void verifyEmailFieldWithInvalidFormat() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
                // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField("InvalidEmail")
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Invalid email, please use next format - email@email.com");
    }

    @Test(description = "Verify email field with free spaces value - ID_24")
    public void verifyEmailFieldWithFreeSpacesValue() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
                // Given
        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField("   ")
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Thank you for your order! TOTAL: " + pizzaCost*quantityNumber + " " + pizzaName);
    }

    @Test(description = "Verify order creation without specified payment type - ID_25")
    public void verifyOrderWithoutPaymentType() {
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
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Please, chose one payment type - Credit card or Cash on Pickup");
    }

    @Test(description = "Verify order creation with two specified payment type - ID_26")
    public void verifyOrderWithTwoSpecifiedPaymentType() {
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
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Please, chose one payment type - Credit card or Cash on Pickup");
    }

    @Test(description = "Verify order creation without any data accept name and phone - ID_27")
    public void verifyOrderCreationWithoutAnyDataAcceptNamePhone() {
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);
        // Given
        pizzaOrderPage
                .setNameField(getFakerUserName())
                .setPhoneField(getFakerPhoneNumber())
                //When
                .clickOnPlaceOrderButton()
                //Then
                .verifyTextInDialog("Please, chose pizza type");
    }
}
