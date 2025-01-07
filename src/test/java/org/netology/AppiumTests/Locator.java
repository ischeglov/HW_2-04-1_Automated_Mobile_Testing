package org.netology.AppiumTests;

import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Locator {
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    public MobileElement textChanged;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    public MobileElement input;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    public MobileElement buttonChange;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    public MobileElement buttonActivity;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    public MobileElement activityText;

    private AppiumDriver driver;

    public Locator(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}