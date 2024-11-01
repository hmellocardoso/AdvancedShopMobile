package org.appium.driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriver {
    static io.appium.java_client.AppiumDriver driver;

    public static io.appium.java_client.AppiumDriver getDriver() throws MalformedURLException {
//        if (driver == null) {
//            initDriver();
//        }
        return driver;
    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Before
    public void initDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", ConfigManager.getProperty("platformName"));
        cap.setCapability("platformVersion", ConfigManager.getProperty("platformVersion"));
        cap.setCapability("deviceName", ConfigManager.getProperty("deviceName"));
        cap.setCapability("appPackage", ConfigManager.getProperty("appPackage"));
        cap.setCapability("appActivity", ConfigManager.getProperty("appActivity"));
        cap.setCapability("automationName", ConfigManager.getProperty("automationName"));
        cap.setCapability("udid", ConfigManager.getProperty("deviceUdid"));

        System.out.println(cap);
        URL url = new URL("http://127.0.0.1:4723");
        driver = new io.appium.java_client.AppiumDriver(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
