package onlinerby_test;

import onlinerby_po_example.po_onliner_pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OnlinerCatalogTest {

    private WebDriver driver;
    private HomePage homePage;
    private Catalog catalog;
    private ProductPage productPage;
    private ProductsList productsList;
    private Bracket bracket;

    @BeforeTest
    public void initDriver (){

        final String BROWSER_PATH = "C:\\Program Files (x86)\\Opera\\launcher.exe";
        OperaOptions options = new OperaOptions().setBinary(BROWSER_PATH);
        driver = new OperaDriver(options);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        homePage.openHomepage();

    }

    @BeforeClass
    public void openCatalog (){

        homePage.openCatalog();
    }

    @BeforeClass (dependsOnMethods = {"openCatalog"})
    public void selectCategory (){
        catalog = new Catalog(driver);
        catalog.selectCategory();
    }

    @BeforeClass(dependsOnMethods = {"selectCategory"})
    public void selectSubCategory (){
        catalog.selectSubCategory();
    }

    @BeforeClass (dependsOnMethods = {"selectSubCategory"})
    public void openProductsList (){
        catalog.openProductsList();
    }

    @BeforeClass(dependsOnMethods = {"openProductsList"})
    public void selectProduct () throws IOException {
        productsList = new ProductsList(driver);
        productsList.getProduct();
    }

    @Test
    public void addProductToBracket () throws IOException {
        productPage = new ProductPage(driver);
        productPage.addProductToBracket();
        productPage.openBracket();

    }

    @Test(dependsOnMethods = {"addProductToBracket"})

    public void checkBracket () {

        bracket = new Bracket(driver);
        Assert.assertFalse(bracket.bracketIsEmpty());

    }

    @AfterTest
    public void closeBrowser (){
        driver.close();
    }

}
