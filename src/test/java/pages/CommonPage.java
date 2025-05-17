package pages;

import helperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {
    public WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    AlertMethods alertMethods;
    FramesMethods framesMethods;
    WindowsMethods windowsMethods;
    Actions actions;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        this.alertMethods = new AlertMethods(driver);
        this.framesMethods = new FramesMethods(driver);
        this.windowsMethods = new WindowsMethods(driver);
        this.actions = new Actions(driver);
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
