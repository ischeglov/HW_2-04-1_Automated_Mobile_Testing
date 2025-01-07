package org.netology.AppiumTests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class AppiumTests {

    private AndroidDriver driver;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "some name");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(getUrl(), desiredCapabilities);
    }

    @Test
    public void TestEmptyText() {
        Locator main = new Locator(driver);

        String textBefore = main.textChanged.getText();
        main.input.sendKeys("");
        main.buttonChange.click();
        String textAfter = main.textChanged.getText();

        assertEquals(textBefore, textAfter);
    }

    @Test
    public void TestNewActivity() {
        Locator main = new Locator(driver);

        main.input.sendKeys("Netology");
        main.buttonActivity.click();
        String textAfter = main.activityText.getText();

        assertEquals("Netology", textAfter);
        driver.navigate().back();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}