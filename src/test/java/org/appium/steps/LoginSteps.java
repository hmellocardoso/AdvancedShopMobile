package org.appium.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.appium.driver.AppiumDriver;
import org.appium.driver.ConfigManager;
import org.appium.screens.HomeScreen;
import org.appium.screens.LoginScreen;
import org.appium.screens.MenuScreen;

import java.net.MalformedURLException;

public class LoginSteps {

    private LoginScreen loginScreen = new LoginScreen(AppiumDriver.getDriver());
    private HomeScreen homeScreen = new HomeScreen(AppiumDriver.getDriver());
    private MenuScreen menuScreen = new MenuScreen(AppiumDriver.getDriver());

    public LoginSteps() throws MalformedURLException {

    }

    @Given("que eu esteja na página de login")
    public void queEuEstejaNaPáginaDeLogin() {
        homeScreen.abrirMenu();
        homeScreen.abrirTelaLogin();
    }

    @When("eu insiro o usuário e senha corretos")
    public void euInsiroOUsuárioESenhaCorretos() {
        loginScreen.enterUsername(ConfigManager.getProperty("userName"));
        loginScreen.enterPassword(ConfigManager.getProperty("password"));
        loginScreen.clickLoginButton();
        loginScreen.recuseFaceIdDetection();
    }

    @Then("eu valido que usuário está logado")
    public void euValidoQueUsuárioEstáLogado() {
        homeScreen.abrirMenu();
        menuScreen.validarLogin(ConfigManager.getProperty("userName"));
    }
}
