package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.PropertiesFile;

import java.net.MalformedURLException;


/**
 * Base class for all tests.
 */
public abstract class BaseTest {

    /**
     * Initialize driver.
     */
    @BeforeMethod
    public void setUp() throws MalformedURLException {

        String browser = PropertiesFile.readFile().getProperty("browser");
        String url = PropertiesFile.readFile().getProperty("baseUrl");

        DriverFactory driverFactory = new DriverFactory();
        driverFactory.init_driver(browser).get(url);
    }

    /**
     * Close driver.
     */
    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        DriverFactory.getDriver().close();
        DriverFactory.getDriver().quit();
    }

}
