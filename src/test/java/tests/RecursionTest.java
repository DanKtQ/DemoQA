package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class RecursionTest {

    WebDriver driver;

    @Test
    public void scrollThroughTheList() throws InterruptedException {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/sortable");
        //setam browserul in modul maximize
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        List<WebElement> listElement = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
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
    }
}
