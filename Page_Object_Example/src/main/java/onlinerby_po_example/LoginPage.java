package onlinerby_po_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage extends Page {

    private final By login_locator = By.cssSelector("div>input[data-field='login']");
    private final By password_locator = By.cssSelector("div>input[type='password']");
    private final By submit_button_locator = By.cssSelector("div>button[type='submit']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login (String username, String password) {

        WebElement loginField = getDriver().findElement(login_locator);
        WebElement passwordField = getDriver().findElement(password_locator);
        WebElement submit = getDriver().findElement(submit_button_locator);

        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        submit.click();

        return new HomePage(driver);

    }


}
