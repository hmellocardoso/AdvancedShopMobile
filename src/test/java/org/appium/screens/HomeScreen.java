package org.appium.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen {
    private AppiumDriver driver;

    public HomeScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.Advantage.aShopping:id/imageViewMenu")
    private WebElement menu;

    @FindBy(id = "com.Advantage.aShopping:id/textViewMenuUser")
    private WebElement menuLogin;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"LAPTOPS Category\"]")
    private WebElement lapTopsCategory;

    public void abrirTelaLogin() {
        menuLogin.click();
    }

    public void abrirMenu(){
        menu.click();
    }

    public void abrirLapTopsCategory(){
        lapTopsCategory.click();
    }


}
