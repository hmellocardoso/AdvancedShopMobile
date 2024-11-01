package org.appium.screens;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsScreen {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public ProductsScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "com.Advantage.aShopping:id/imageViewFilter")
    private WebElement filter;

    @FindBy(id = "com.Advantage.aShopping:id/textViewClear")
    private WebElement clearButton;

    @FindBy(id = "com.Advantage.aShopping:id/gridViewProducts")
    private WebElement productsGrid;

    public void abrirFiltro(){
        wait.until(ExpectedConditions.elementToBeClickable(productsGrid));
        filter.click();
    }

    public void validarFiltroAplicado(){
        Assert.assertTrue(clearButton.isDisplayed());
    }

}
