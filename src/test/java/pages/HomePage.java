package pages;

import org.openqa.selenium.By;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
    public void login(String email, String password) throws Exception {
        if (!isDisplayed(singInButton)){
            throw new Exception("Elemento no Encontrado");
        }
        type(email, emailInput);
        sleep(1500);
        type(password, passwordInput);
        sleep(1000);
        click(singInButton);
        sleep(1000);

    }
}
