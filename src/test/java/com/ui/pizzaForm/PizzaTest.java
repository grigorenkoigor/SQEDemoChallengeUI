package com.ui.pizzaForm;

import com.sample.test.pizzaForm.TestBase;
import com.sample.test.pizzaForm.constants.PizzaToppings;
import com.ui.PizzaOrderFormPage;
import org.testng.annotations.Test;

import static com.sample.test.pizzaForm.utilits.DataGenerator.*;


public class PizzaTest extends TestBase {

    @Test
    public void openPizzaPage(){
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);

        pizzaOrderPage
                .setQuantityField(2)
                .selectFromDropDownToppings1(PizzaToppings.EXTRACHEESE.getDisplayName())
                .selectFromDropDownToppings2(PizzaToppings.MOZZARELLA.getDisplayName())
                .setNameField(getFakerUserName())
                .setEmailField(getFakerEmailAddress())
                .setPhoneField(getFakerPhoneNumber());

    }
}
