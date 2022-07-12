package data.factory;

import com.github.javafaker.Faker;
import models.UserModel;
import utils.PropertiesFile;

import static builder.UserModelBuilder.builder;

/**
 * This class is used to create a data for the UserModel object.
 */
public class UserModelFactory {

    private static final Faker faker = new Faker();
    private static final String DEFAULT_EMAIL = PropertiesFile.readFile().getProperty("DEFAULT_EMAIL");
    private static final String DEFAULT_PASSWORD = PropertiesFile.readFile().getProperty("DEFAULT_PASSWORD");

    /**
     * this method is to create data with valid information
     *
     * @return UserModel object
     */
    public static UserModel validUser() {
        return builder()
                .setFirstName(faker.name().firstName())
                .and()
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password())
                .build();
    }

    /**
     * this method is to create data to log in with valid information
     *
     * @return UserModel object
     */
    public static UserModel loginUser() {
        return builder()
                .setEmail(DEFAULT_EMAIL)
                .and()
                .setPassword(DEFAULT_PASSWORD)
                .build();
    }

    /**
     * this method is to create data to log in with invalid information
     *
     * @return UserModel object
     */
    public static UserModel invalidInformation() {
        return builder()
                .setEmail(DEFAULT_EMAIL)
                .and()
                .setPassword(DEFAULT_PASSWORD + "1")
                .build();
    }

}
