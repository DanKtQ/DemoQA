package tests;

import helperMethods.AlertMethods;
import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import sharedData.TestBase;

public class AlertsTest extends TestBase {

    ElementsMethods elementsMethods;
    AlertMethods alertMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void accessAlertsPage() {

        elementsMethods = new ElementsMethods(driver);
        alertMethods = new AlertMethods(driver);
        javascriptMethods = new JavascriptMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Alerts");

        WebElement alertOkElement = driver.findElement(By.id("alertButton"));
        elementsMethods.clickOnElements(alertOkElement);
        //ne mutam cu focusul pe alerta si dam ok
        alertMethods.interactOKWithAlerts();

        WebElement alertDelayElement = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.clickOnElements(alertDelayElement);
        //definim un wait explicit ca sa astepte dupa alerta
        alertMethods.explicitAlertWait();
        //ne mutam cu focusul pe alerta si dam ok
        alertMethods.interactOKWithAlerts();

        WebElement alertConfirmationElement = driver.findElement(By.id("confirmButton"));
        elementsMethods.clickOnElements(alertConfirmationElement);
        //ne mutam cu focusul pe alerta si dam cancel
        alertMethods.interactDismissWithAlerts();

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        elementsMethods.clickOnElements(alertPromptElement);
        //ne mutam cu focusul pe alerta, completam campul si dam OK
        alertMethods.interactAndFillWithAlert("Automation");
    }
}