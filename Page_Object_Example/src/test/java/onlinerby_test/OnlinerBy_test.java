package onlinerby_test;

import onlinerby_po_example.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OnlinerBy_test {

    WebDriver driver;
    HomePage homePage;
    Catalog catalog;
    LoginPage loginPage;
    ProductPage productPage;
    ProductsList productsList;
    Bracket bracket;

    @BeforeTest
    public void initDriver (){

        final String BROWSER_PATH = "C:\\Program Files (x86)\\Opera\\launcher.exe";
        OperaOptions options = new OperaOptions().setBinary(BROWSER_PATH);
        driver = new OperaDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        homePage.openHomepage();
    }

    @Test (enabled = false)
    public void login (){

       loginPage = new LoginPage(driver);
       homePage.openLoginPage();
       loginPage.login("", ""); // insert needed login and password here
    }

    @Test
    public void openCatalog (){

        homePage.openCatalog();
    }

    @Test (dependsOnMethods = {"openCatalog"})
    public void selectCategory (){
        catalog = new Catalog(driver);
        catalog.selectCategory();
    }

    @Test(dependsOnMethods = {"selectCategory"})
    public void selectSubCategory (){
        catalog.selectSubCategory();
    }

    @Test (dependsOnMethods = {"selectSubCategory"})
    public void openProductsList (){
        catalog.openProductsList();
    }

    @Test(dependsOnMethods = {"openProductsList"})
    public void selectProduct () throws IOException {
        ProductsList productList = new ProductsList(driver);
        productList.getProduct();
    }

    @Test(dependsOnMethods = {"selectProduct"})
    public void addProductToBracket () throws IOException {
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToBracket();


    }

    @Test(enabled = false)
    public void checkBracket (){
        Bracket bracket = new Bracket(driver);

    }

    @AfterTest
    public void closeBrowser (){
        driver.close();
    }

}
