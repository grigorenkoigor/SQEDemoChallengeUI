package com.sample.test.pizzaForm.utilits;

import com.sample.test.pizzaForm.constants.PizzaToppings;
import com.sample.test.pizzaForm.constants.PizzaTypes;
import org.testng.annotations.DataProvider;

public class PizzaDataProvider {

    @DataProvider(name = "Pizza set")
    public static Object[][] pizzaSet() {
        return new Object[][]{
                {PizzaTypes.SMALL_NOTOPPINGS.getDisplayName(), PizzaToppings.MOZZARELLA.getDisplayName(), PizzaToppings.EXTRACHEESE.getDisplayName(), PizzaTypes.SMALL_NOTOPPINGS.getCost(), 2},
                {PizzaTypes.SMALL_ONETOPPINGS.getDisplayName(), PizzaToppings.PEPPERONI.getDisplayName(), PizzaToppings.PROVOLNE.getDisplayName(), PizzaTypes.SMALL_ONETOPPINGS.getCost(), 3},
                {PizzaTypes.LARE_NOTOPPINGS.getDisplayName(), PizzaToppings.ITALIANHAM.getDisplayName(), PizzaToppings.MANGOS.getDisplayName(), PizzaTypes.LARE_NOTOPPINGS.getCost(), 1},
                {PizzaTypes.LARGE_THREETOPPINGS.getDisplayName(), PizzaToppings.OLIVES.getDisplayName(), PizzaToppings.PARMASAN.getDisplayName(), PizzaTypes.LARGE_THREETOPPINGS.getCost(), 3},
                {PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName(), PizzaToppings.SALAMI.getDisplayName(), PizzaToppings.PARMASAN.getDisplayName(), PizzaTypes.MEDIUM_TWOTOPPINGS.getCost(), 5}
        };
    }
}