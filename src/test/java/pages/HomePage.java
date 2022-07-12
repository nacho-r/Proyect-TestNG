package pages;

import org.openqa.selenium.By;

/**
 * Class that represents the Home page of the application.
 */
public class HomePage extends Base {

    private final By emailInput = By.id("uid");
    private final By passwordInput = By.id("passw");
    private final By singInButton = By.xpath("//input[@value=\"Login\"]");



    /**
     * Constructor of the class.
     */
    public HomePage() {
        super();
    }

    /**
     * Method that allows to click on the Sign In button.
     */
    public void login(String email, String password) {
        type(email, emailInput);
        type(password, passwordInput);
        click(singInButton);
    }
}
