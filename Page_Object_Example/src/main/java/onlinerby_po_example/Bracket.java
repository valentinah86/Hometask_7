package onlinerby_po_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bracket extends Page{

    private By brasketLocator = By.xpath("//a[@class='b-top-navigation-cart__link']");

    public Bracket(WebDriver driver) {
        super(driver);
    }

    public void openBracket (){
        WebElement bracket = getDriver().findElement(brasketLocator);
        bracket.click();
    }


}
