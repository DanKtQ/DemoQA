package pages;

import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class HomePage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;

    // Identificam webElementele specifice pentru aceasta pagina
    @FindBy(xpath = "//h5")
    private List<WebElement> alertFrameWindowElement;

    @FindBy(xpath = "//p[text()='Consent']")
    private WebElement consentElement;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        PageFactory.initElements(driver, this);
    }

    // Facem metode specifice pentru pagina aceasta
    public void goToDesiredMenu(String menu) {
//        elementsMethods.clickOnElements(consentElement);
//        LoggerUtility.infoLog("The user clicks on consentElement");

        javascriptMethods.scrollDown(400);
        LoggerUtility.infoLog("The user scrolls down the page");

        elementsMethods.findElement(alertFrameWindowElement, menu);
        LoggerUtility.infoLog("The user selects from menu the option with the value: " + menu);
    }

}
