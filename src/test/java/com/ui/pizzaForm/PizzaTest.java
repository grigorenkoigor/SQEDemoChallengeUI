package com.ui.pizzaForm;

import com.sample.test.pizzaForm.TestBase;
import com.ui.PizzaOrderFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class PizzaTest extends TestBase {

    WebDriver driver;
    PizzaOrderFormPage pizzaOrderFormPage = new PizzaOrderFormPage();

    @Test
    void openPizzaPage(){
        pizzaOrderFormPage
                .setQuantityField(2)
                .setNameField("Ihor")
                .setEmailField("qwe@qwe.com")
                .setPhoneField("0931112233");
    }
}
