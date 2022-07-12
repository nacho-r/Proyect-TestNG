package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class that manages the driver instance.
 */
public class DriverFactory {

    public static ThreadLocal<WebDriver> hiloLocal = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    /**
     * Method that returns the driver instance.
     *
     * @param browser Browser to use.
     * @return WebDriver instance.
     */
    public WebDriver init_driver(String browser) throws MalformedURLException {

        boolean remote = Boolean.parseBoolean(PropertiesFile.readFile().getProperty("remote"));

        logger.info("Running tests on " + browser + " browser and " + (remote ? "remote" : "local") + " execution");

        if (remote) {

            String browserVersion = PropertiesFile.readFile().getProperty("browserRemoteVersion");
            String remoteUrl = PropertiesFile.readFile().getProperty("REMOTE_URL");
            boolean enableVNC = Boolean.parseBoolean(PropertiesFile.readFile().getProperty("enableVNC"));
            boolean enableVideo = Boolean.parseBoolean(PropertiesFile.readFile().getProperty("enableVideo"));

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setVersion(browserVersion);
            capabilities.setCapability("enableVNC", enableVNC);
            capabilities.setCapability("enableVideo", enableVideo);

            hiloLocal.set(new RemoteWebDriver(new URL(remoteUrl), capabilities));
            getDriver().manage().deleteAllCookies();
            getDriver().manage().window().maximize();
            return getDriver();
        }

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            hiloLocal.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            hiloLocal.set(new FirefoxDriver());
        } else {
            throw new IllegalArgumentException("Browser " + browser + " is not supported");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    /**
     * Method that returns the driver instance used in the current thread.
     *
     * @return WebDriver instance.
     */
    public static synchronized WebDriver getDriver() {
        return hiloLocal.get();
    }
}