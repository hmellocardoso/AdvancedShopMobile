package org.appium.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.appium.driver.AppiumDriver;
import org.appium.driver.ConfigManager;
import org.appium.screens.FilterScreen;
import org.appium.screens.HomeScreen;
import org.appium.screens.ProductsScreen;

import java.net.MalformedURLException;

public class FilterSteps {

    private HomeScreen homeScreen = new HomeScreen(AppiumDriver.getDriver());
    private ProductsScreen productsScreen = new ProductsScreen(AppiumDriver.getDriver());
    private FilterScreen filterScreen = new FilterScreen(AppiumDriver.getDriver());

    public FilterSteps() throws MalformedURLException {
    }

    @Given("que eu esteja na página de laptops")
    public void queEuEstejaNaPáginaDeLaptops() {
        homeScreen.abrirLapTopsCategory();
    }


    @When("eu filtro por sistema operacional")
    public void euFiltroPorSistemaOperacional() throws MalformedURLException {
        productsScreen.abrirFiltro();
        filterScreen.abrirOpcoesSistemaOperacional();
        filterScreen.selecionaOpcaoSistemaOperacional(ConfigManager.getProperty("opcaoSistemaOperacional"));
        filterScreen.aplicarFiltro();
    }

    @Then("eu valido que o filtro foi aplicado")
    public void euValidoQueOFiltroFoiAplicado() {
        productsScreen.validarFiltroAplicado();
    }
}
