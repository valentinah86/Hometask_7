package onlinerby_po_example.po_onliner_pages;

import onlinerby_po_example.po_page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Catalog extends Page {

    private Random random = new Random();

    private final By categoriesList = By.xpath("//div[@class='catalog-navigation']//li[@class='catalog-navigation-classifier__item ']");
    private final By subcategoriesList = By.xpath("//div[@class='catalog-navigation-list__category'][@style='display: block;']//div[@class='catalog-navigation-list__aside-item']");
    private final By productListLocator = By.xpath("//div[@class='catalog-navigation-list__dropdown-list']");

    public Catalog(WebDriver driver) {
        super(driver);
    }

    public void selectCategory () {

        List<WebElement> categories = driver.findElements(categoriesList);
        WebElement category = categories.get(random.nextInt(categories.size()));
        category.click();
    }

    public void selectSubCategory (){

        List<WebElement> subcategoties = driver.findElements(subcategoriesList);
        WebElement subcategory = subcategoties.get(random.nextInt(subcategoties.size()));
        subcategory.click();

    }

    public ProductsList openProductsList (){

        List<WebElement> allProductsList = driver.findElements(productListLocator);
        List<WebElement> visibleProducts = allProductsList.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        WebElement productList = visibleProducts.get(random.nextInt(visibleProducts.size()));
        productList.click();


        return new ProductsList(driver);
    }


}
