package onlinerby_po_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ProductPage extends Page {

    private Random random = new Random();

    private By pricesLocator = By.xpath("//a[@data-href='https://cart.onliner.by']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToBracket () throws IOException {

       List<WebElement> offers =  getDriver().findElements(pricesLocator);
       if (offers.size()>0) {
           WebElement offer = offers.get(random.nextInt(offers.size()));
           offer.click();
       }else throw new IOException("Нет доступных предложений");

    }

}
