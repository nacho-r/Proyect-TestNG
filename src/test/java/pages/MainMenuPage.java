package pages;

import org.openqa.selenium.By;

import java.time.Duration;

/**
 * Class that represents the Dashboard page.
 */
public class MainMenuPage extends Base {

    private final By helloName = By.xpath("//div/h1[contains(text(),\"Hello\")]");
    private final By transferFunds = By.id("MenuHyperLink3");


    /**
     * Constructor of the class.
     */
    public MainMenuPage() {
        super();
    }

    /**
     * Method that returns the username of the user.
     *
     * @return the username of the user.
     */
    public String getTitle() {
        return getText(helloName);
    }

    /**
     * Method that clicks on the course card given the name of the course.
     *
     * @param courseCardName the name of the course.
     */
    public void clickOptionMenu() {
        click(transferFunds);
    }

}