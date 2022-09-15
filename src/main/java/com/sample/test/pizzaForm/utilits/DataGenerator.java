package com.sample.test.pizzaForm.utilits;

import com.github.javafaker.Faker;

public class DataGenerator {

    private static Faker faker = new Faker();

    /**
     * Generate faker email address with valid format
     * @return a random string email "hayes@yahoo.com"
     */
    public static String getFakerEmailAddress() {
        return faker.internet().emailAddress();
    }

    /**
     * Generate faker first and last names
     * @return a random string "Jamienpb Jaskolski"
     */
    public static String getFakerUserName() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    /**
     * Generate faker phone number
     * @return a random phone number "Jamienpb Jaskolski"
     */
    public static String getFakerPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }
}
