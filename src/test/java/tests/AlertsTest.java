package tests;

import helperMethods.AlertMethods;
import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import sharedData.Hooks;
import org.testng.annotations.Test;

public class AlertsTest extends Hooks {

    ElementsMethods elementsMethods;
    AlertMethods alertMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void accessAlertsTests() {

        System.out.println("Acesta este testul de Alerts");

        elementsMethods = new ElementsMethods(getDriver());
        alertMethods = new AlertMethods(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());
        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Alerts");

        WebElement alertOkElement = getDriver().findElement(By.id("alertButton"));
        elementsMethods.clickOnElements(alertOkElement);
        //ne mutam cu focusul pe alerta si dam ok
        alertMethods.interactOKWithAlerts();

        WebElement alertDelayElement = getDriver().findElement(By.id("timerAlertButton"));
        elementsMethods.clickOnElements(alertDelayElement);
        //definim un wait explicit ca sa astepte dupa alerta
        alertMethods.explicitAlertWait();
        //ne mutam cu focusul pe alerta si dam ok
        alertMethods.interactOKWithAlerts();

        WebElement alertConfirmationElement = getDriver().findElement(By.id("confirmButton"));
        elementsMethods.clickOnElements(alertConfirmationElement);
        //ne mutam cu focusul pe alerta si dam cancel
        alertMethods.interactDismissWithAlerts();

        WebElement alertPromptElement = getDriver().findElement(By.id("promtButton"));
        elementsMethods.clickOnElements(alertPromptElement);
        //ne mutam cu focusul pe alerta, completam campul si dam OK
        alertMethods.interactAndFillWithAlert("Automation");
    }
}