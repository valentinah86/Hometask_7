package onlinerby_test;

import onlinerby_po_example.po_onliner_pages.HomePage;
import onlinerby_po_example.po_onliner_pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OnlinerLoginTest {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeTest
    public void initDriver (){

        final String BROWSER_PATH = "C:\\Program Files (x86)\\Opera\\launcher.exe";
        OperaOptions options = new OperaOptions().setBinary(BROWSER_PATH);
        driver = new OperaDriver(options);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        homePage.openHomepage();
    }

    @Test
    public void login (){

        loginPage = new LoginPage(driver);
        homePage.openLoginPage();
        loginPage.login("hamster_bb", "5598109"); // insert needed login and password here
        Assert.assertTrue(homePage.isUserSignedUp());
    }

    @AfterTest (enabled = false)
    public void closeBrowser (){
        driver.close();
    }

}
