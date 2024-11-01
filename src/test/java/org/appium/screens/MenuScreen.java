package org.appium.screens;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuScreen {
    private AppiumDriver driver;

    public MenuScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.Advantage.aShopping:id/textViewMenuUser")
    private WebElement usernameLogged;

    public void validarLogin(String username){
        Assert.assertTrue(usernameLogged.getText().equals(username));
    }
}
