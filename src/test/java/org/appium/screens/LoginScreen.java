package org.appium.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScreen {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public LoginScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"User Name\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Password\"]")
    private WebElement passwordField;

    @FindBy(id = "com.Advantage.aShopping:id/buttonLogin")
    private WebElement loginButton;

    @FindBy(id = "android:id/button2")
    private WebElement recuseFaceIdDetection;

    public void enterUsername(String username) {
        usernameField.click();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void recuseFaceIdDetection()
    {
        wait.until(ExpectedConditions.visibilityOf(recuseFaceIdDetection));
        wait.until(ExpectedConditions.elementToBeClickable(recuseFaceIdDetection));
        recuseFaceIdDetection.click();
    }
}
