package org.appium.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class FilterScreen {
    private AppiumDriver driver;
    private WebDriverWait wait;
    public FilterScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.Advantage.aShopping:id/textViewFilterCategoryTitle\" and @text=\"BY OPERATING SYSTEM\"]")
    private WebElement filterOperationSystem;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.Advantage.aShopping:id/textViewFilterCategoryTitle\" and @text=\"Windows 10\"]")
    private WebElement optionWindows10;

    @FindBy(id = "com.Advantage.aShopping:id/textViewApply")
    private WebElement applyButton;

    public void abrirOpcoesSistemaOperacional(){
        filterOperationSystem.click();
    }

    public void selecionaOpcaoSistemaOperacional(String opcao) throws MalformedURLException {
        WebElement element = org.appium.driver.AppiumDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.Advantage.aShopping:id/textViewFilterCategoryTitle\" and @text=\""+opcao+"\"]"));
        element.click();
    }

    public void aplicarFiltro(){
        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        applyButton.click();
    }
}
