package onlinerby_po_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends Page {

    private String url = "http://onliner.by";

    private final By catalog_locator = By.linkText("Каталог");
    private final By login_locator = By.className("auth-bar__item");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomepage (){
        getDriver().get(url);
    }

    public LoginPage openLoginPage (){

        WebElement login = getDriver().findElement(login_locator);
        login.click();

        return new LoginPage(driver);
    }

    public Catalog openCatalog (){

        WebElement catalog = getDriver().findElement(catalog_locator);
        catalog.click();

        return new Catalog(driver);
    }

}
