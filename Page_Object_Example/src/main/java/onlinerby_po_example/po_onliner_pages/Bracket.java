package onlinerby_po_example.po_onliner_pages;

import onlinerby_po_example.po_page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bracket extends Page {

    //private By emptyCartMessage = By.xpath("//div[@class='cart-message__wrapper']/div[@class='cart-message__description']");
    private By productTitle = By.xpath("//div[@class='cart-product-title']//span");

    public Bracket(WebDriver driver) {
        super(driver);
    }


    public boolean bracketIsEmpty (){

        if (getProductInBracket().isDisplayed()==false)
        {return true;}
        else return false;
    }

    public WebElement getProductInBracket (){

        WebElement productInBracket = getDriver().findElement(productTitle);

        return productInBracket;
    }


}
