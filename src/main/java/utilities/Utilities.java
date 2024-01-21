package utilities;

import com.github.javafaker.Faker;

import java.util.Date;

public class Utilities {

    //Change implicit and page wait time (in seconds)
    public static final int IMPLICIT_WAIT_TIME = 10;
    public static final int PAGE_WAIT_TIME = 25;

    //Random generators ---------------------------------
    public static String fakerGenerateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String fakerGenerateFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String fakerGenerateLastName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static String fakerGenerateTelephone() {
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber().replace("-", "").replace("x", "");
    }

    public static String fakerGenerateCity() {
        Faker faker = new Faker();
        return faker.address().city();
    }

    public static String fakerGenerateAddress() {
        Faker faker = new Faker();
        return faker.address().streetName();
    }

    public static String fakerGeneratePostCode() {
        Faker faker = new Faker();
        return faker.address().zipCode();
    }

    public static String generatedEmailWithTimeStamp() {
        Date date = new Date();
        String timestamp = date.toString().replace(" ", "_").replace(":", "_");
        return timestamp + fakerGenerateEmail();
    }

}
