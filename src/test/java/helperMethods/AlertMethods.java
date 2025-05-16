package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {
    WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void interactOKWithAlerts() {
        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();
    }

    public void interactDismissWithAlerts() {
        Alert alertDismiss = driver.switchTo().alert();
        alertDismiss.dismiss();
    }

    public void interactAndFillWithAlert(String value) {
        Alert alertFill = driver.switchTo().alert();
        alertFill.sendKeys(value);
        alertFill.accept();
    }

    public void explicitAlertWait(){
        //definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
