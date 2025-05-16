package pages;

import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {
    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        PageFactory.initElements(driver, this);
    }

    // Identificam webElementele specifice pentru aceasta pagina
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    // Facem metode specifice pentru pagina aceasta
    public void goToDesiredSubMenu(String submenu) {
        javascriptMethods.scrollDown(400);
        elementsMethods.findElement(elements, submenu);
    }

}
