package pages;

import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;

    // Identificam webElementele specifice pentru aceasta pagina
    @FindBy(xpath = "//h5")
    private List<WebElement> alertFrameWindowElement;

//    @FindBy(xpath = "//p[text()='Consent']")
//    WebElement consentElement;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        PageFactory.initElements(driver, this);
    }

    // Facem metode specifice pentru pagina aceasta
    public void goToDesiredMenu(String menu) {
//        elementsMethods.clickOnElements(consentElement);
        javascriptMethods.scrollDown(400);
        elementsMethods.findElement(alertFrameWindowElement, menu);
    }

}
