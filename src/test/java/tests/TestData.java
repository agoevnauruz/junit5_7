package tests;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();
    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String userEmail = faker.internet().emailAddress();
    //static String userAdress = String.valueOf(faker.address());
    static String userAdress = String.valueOf(faker.address());
    static String userNumber = String.valueOf(faker.number().randomNumber(10, true));

}
