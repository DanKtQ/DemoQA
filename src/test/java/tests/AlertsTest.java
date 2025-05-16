package tests;

import helperMethods.AlertMethods;
import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import pages.CommonPage;
import pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertsTest {
    WebDriver driver;
    ElementsMethods elementsMethods;
    AlertMethods alertMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void accessAlertsPage() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //setam browserul in modul maximize
        driver.manage().window().maximize();

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