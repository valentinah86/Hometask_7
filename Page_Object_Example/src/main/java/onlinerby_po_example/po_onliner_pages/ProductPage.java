package onlinerby_po_example.po_onliner_pages;

import onlinerby_po_example.po_page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ProductPage extends Page {

    private Random random = new Random();

    private By pricesLocator = By.xpath("//a[@data-href='https://cart.onliner.by']");

    private By bracketLocator = By.xpath("//li[@class='b-top-navigation-cart__item b-top-navigation-cart__item_active']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToBracket () throws IOException {

       List<WebElement> offers =  getDriver().findElements(pricesLocator);
       if (offers.size()>0) {
           WebElement offer = offers.get(random.nextInt(offers.size()));
           offer.click();
       }else throw new IOException("No offers for selected product.");

    }

    public Bracket openBracket (){

        WebElement bracket = getDriver().findElement(bracketLocator);
        bracket.click();

        return new Bracket(driver);
    }



}
