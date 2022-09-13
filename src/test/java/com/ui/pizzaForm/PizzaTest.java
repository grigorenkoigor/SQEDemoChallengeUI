package com.ui.pizzaForm;

import com.sample.test.pizzaForm.TestBase;
import com.sample.test.pizzaForm.utilits.PizzaDataProvider;
import com.ui.PizzaOrderFormPage;
import org.testng.annotations.Test;

import static com.sample.test.pizzaForm.utilits.DataGenerator.*;


public class PizzaTest extends TestBase {

    @Test(description = "Verify happy path fro different pizzas with different toppings with paying by credit card ID_1-ID_5",
            dataProvider = "Pizza set", dataProviderClass = PizzaDataProvider.class)
    public void VerifyHappyPathWithCreditCard(String pizzaName, String topping1, String topping2, double pizzaCost, int quantityNumber){
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);

        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCreditCard()
                .clickOnPlaceOrderButton()
                .verifyTextInDialog("Thank you for your order! TOTAL: " + pizzaCost*quantityNumber + " " + pizzaName)
                .clickByClosePopUpButton();
    }

    @Test(description = "Verify happy path for different pizzas with different toppings with paying by cash on pick up ID_6-ID_10",
            dataProvider = "Pizza set", dataProviderClass = PizzaDataProvider.class)
    public void VerifyHappyPathWithCashOnPickUp(String pizzaName, String topping1, String topping2, double pizzaCost, int quantityNumber){
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);

        pizzaOrderPage
                .selectFromDropDownPizzaType(pizzaName)
                .selectFromDropDownToppings1(topping1)
                .selectFromDropDownToppings2(topping2)
                .setQuantityField(quantityNumber)
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber())
                .selectPayByCash()
                .clickOnPlaceOrderButton()
                .verifyTextInDialog("Thank you for your order! TOTAL: " + pizzaCost*quantityNumber + " " + pizzaName)
                .clickByClosePopUpButton();
    }
}
