package builder;

import models.UserModel;

/**
 * Builder for {@link UserModel}.
 */
public class UserModelBuilder {

    private final UserModel userModel;

    /**
     * Constructor of the class.
     */
    private UserModelBuilder() {
        userModel = new UserModel();
    }

    /**
     * Creates a new instance of {@link UserModelBuilder}.
     *
     * @return a new instance of {@link UserModelBuilder}.
     */
    public static UserModelBuilder builder() {
        return new UserModelBuilder();
    }

    /**
     * Method to chain method calls.
     *
     * @return an instance of {@link UserModelBuilder}.
     */
    public UserModelBuilder and() {
        return this;
    }

    /**
     * Method to set the first name.
     *
     * @param firstName the first name.
     * @return an instance of {@link UserModelBuilder}.
     */
    public UserModelBuilder setFirstName(String firstName) {
        this.userModel.setFirstName(firstName);
        return this;
    }

    /**
     * Method to set the last name.
     *
     * @param lastName the last name.
     * @return an instance of {@link UserModelBuilder}.
     */
    public UserModelBuilder setLastName(String lastName) {
        this.userModel.setLastName(lastName);
        return this;
    }

    /**
     * Method to set the email.
     *
     * @param email the email.
     * @return an instance of {@link UserModelBuilder}.
     */
    public UserModelBuilder setEmail(String email) {
        this.userModel.setEmail(email);
        return this;
    }

    /**
     * Method to set the password.
     *
     * @param password the password.
     * @return an instance of {@link UserModelBuilder}.
     */
    public UserModelBuilder setPassword(String password) {
        this.userModel.setPassword(password);
        return this;
    }

    /**
     * Method to build the {@link UserModel}.
     *
     * @return an instance of {@link UserModel}.
     */
    public UserModel build() {
        return userModel;
    }

}
