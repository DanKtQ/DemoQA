package pages;

import logger.LoggerUtility;
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
        LoggerUtility.infoLog("The user interacts with the Simple alert");
    }


    public void alertDelay(){
        elementsMethods.clickOnElements(delayedAlertButtonElement);
        LoggerUtility.infoLog("The user interacts with the Delayed alert");
    }

    public void alertConfirm(){
        elementsMethods.clickOnElements(alertConfirmButtonElement);
        LoggerUtility.infoLog("The user clicks on alertConfirmButtonElement");

    }

    public void alertPrompt(){
        elementsMethods.clickOnElements(alertPromptButtonElement);
        LoggerUtility.infoLog("The user clicks on alertPromptButtonElement");
    }
}
