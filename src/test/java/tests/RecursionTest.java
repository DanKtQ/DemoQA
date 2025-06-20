package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import sharedData.Hooks;

import java.util.List;

public class RecursionTest extends Hooks {

    @Test
    public void scrollThroughTheList() throws InterruptedException {

        Actions actions = new Actions(getDriver());
        List<WebElement> listElement = getDriver().findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for (int i = 0; i < listElement.size() - 1; i++) {
            WebElement currentElement = listElement.get(i);
            WebElement nextElement = listElement.get(i + 1);
            System.out.println("Element: " + currentElement.getText());
            actions.clickAndHold(currentElement)
                    .moveToElement(nextElement)
                    .release()
                    .build()
                    .perform();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters Interactions menu");
    }
}
