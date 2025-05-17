package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends CommonPage {
    @FindBy(id = "alertButton")
    private WebElement alertOkButtonElement;
    @FindBy(id = "timerAlertButton")
    private WebElement delayedAlertButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement alertConfirmButtonElement;
    @FindBy(id = "promtButton")
    private WebElement alertPromptButtonElement;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void simpleAlert(){
        elementsMethods.clickOnElements(alertOkButtonElement);
    }

    public void alertDelay(){
        elementsMethods.clickOnElements(delayedAlertButtonElement);
    }

    public void alertConfirm(){
        elementsMethods.clickOnElements(alertConfirmButtonElement);
    }

    public void alertPrompt(){
        elementsMethods.clickOnElements(alertPromptButtonElement);
    }
}
