package com.cinescope.api;

import com.cinescope.api.payloads.UserPayload;
import com.github.javafaker.Faker;
import org.aeonbits.owner.ConfigFactory;

public class UserGenerator {

    private static Faker faker;

    static {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        faker = new Faker(new java.util.Locale(config.locale()));
    }


    public static UserPayload generateRandomUser() {
        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = "Qq12345678";

        UserPayload user = new UserPayload()
                .fullName(fullName)
                .email(email)
                .password(password)
                .passwordRepeat(password);
        return user;
    }


    public static UserPayload generateUserEmail(String email) {
        UserPayload user = generateRandomUser();
        user.email(email);
        return user;
    }


    public static UserPayload generateUserWithFullName(String fullName) {
        UserPayload user = generateRandomUser();
        user.fullName(fullName);
        return user;
    }


    public static UserPayload generateUserWithPassword(String password) {
        UserPayload user = generateRandomUser();
        user.password(password);
        user.passwordRepeat(password);
        return user;
    }

}
