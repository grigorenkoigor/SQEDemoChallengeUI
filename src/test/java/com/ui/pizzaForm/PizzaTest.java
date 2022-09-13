package com.ui.pizzaForm;

import com.sample.test.pizzaForm.TestBase;
import com.ui.PizzaOrderFormPage;
import org.testng.annotations.Test;


public class PizzaTest extends TestBase {

    @Test
    public void openPizzaPage(){
        PizzaOrderFormPage pizzaOrderPage = new PizzaOrderFormPage(driver);

        pizzaOrderPage
                .setQuantityField(2)
                .setNameField("Ihor")
                .setEmailField("qwe@qwe.com")
                .setPhoneField("0931112233");
    }
}
