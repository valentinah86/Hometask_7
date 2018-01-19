package onlinerby_po_example.po_onliner_pages;

import onlinerby_po_example.po_page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ProductsList extends Page {

    private By productsListLocator = By.xpath("//a[@class='schema-product__button button button_orange']");

    private Random random = new Random();


    public ProductsList(WebDriver driver) {
        super(driver);
    }

    public ProductPage getProduct () throws IOException {

        List <WebElement> productsList = getDriver().findElements(productsListLocator);
        if (productsList.size()>0){
            WebElement product = productsList.get(random.nextInt(productsList.size()));
            product.click();
        } else {
            throw new IOException ("No offers in selected category");
        }

        return new ProductPage(driver);
    }



}
