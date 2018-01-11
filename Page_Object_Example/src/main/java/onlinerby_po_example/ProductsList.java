package onlinerby_po_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ProductsList extends Page {

    private By productsListLocator = By.xpath("//a[@class='schema-product__button button button_orange']");
    private Random random = new Random();
    private String selectedProduct;

    public ProductsList(WebDriver driver) {
        super(driver);
    }

    public ProductPage getProduct () throws IOException {

        List <WebElement> productsList = getDriver().findElements(productsListLocator);
        if (productsList.size()>0){
            WebElement product = productsList.get(random.nextInt(productsList.size()));
            selectedProduct = product.getText();
            product.click();
        } else {
            throw new IOException ("Нет доступных предложений");
        }

        return new ProductPage(driver);
    }

    public String getSelectedProduct (){
        return selectedProduct;
    }

}
