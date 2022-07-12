package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;
import java.util.List;

/**
 * Base class for all pages.
 */
public abstract class Base {

    private final WebDriver driver;

    /**
     * Constructor of the class.
     */
    public Base() {
        driver = DriverFactory.getDriver();
    }

    /**
     * Finds an element by the given locator.
     *
     * @param locator The locator of the element.
     * @param timeout the timeout waiting for the element.
     * @return WebElement.
     */
    public WebElement findElement(By locator, Duration timeout) {
        return new WebDriverWait(this.driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Finds elements by the given locator.
     *
     * @param locator The locator of the element.
     * @param timeout the timeout waiting for the element.
     * @return List of WebElements.
     */
    public List<WebElement> findElements(By locator, Duration timeout) {
        return new WebDriverWait(this.driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * Finds an element by the given locator and type the given text.
     *
     * @param inputText The text to type.
     * @param locator   The locator of the element.
     */
    public void type(String inputText, By locator) {
        findElement(locator, Duration.ofSeconds(10)).sendKeys(inputText);
    }

    /**
     * Finds an element by the given locator and clicks on it.
     *
     * @param locator The locator of the element.
     */
    public void click(By locator) {
        findElement(locator, Duration.ofSeconds(10)).click();
    }

    /**
     * Finds an element by the given text and clicks on it.
     *
     * @param linkText The text of the link.
     */
    public void clickLink(String linkText) {
        click(By.xpath("//a[contains(text(), '" + linkText + "')]"));
    }

    /**
     * Finds an element by the given text and returns it.
     *
     * @param locator The locator of the element.
     * @return WebElement
     */
    public String getText(By locator) {
        return findElement(locator, Duration.ofSeconds(10)).getText();
    }

}
