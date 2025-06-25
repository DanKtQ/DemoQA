package helperMethods;

import logger.LoggerUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementsMethods {

    public WebDriver driver;
    public WebElement element;
    public Actions actions;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void clickOnElements(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            element.click();
        } catch (ElementClickInterceptedException e) {
            // If an ad or overlay is in the way, fallback to JS click
            LoggerUtility.infoLog("⚠️ Click intercepted, trying JS click: " + e.getMessage());
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            LoggerUtility.infoLog("❌ Failed to click element: " + e.getMessage());
        }
    }

    public void selectByValue(WebElement element, String value) {
        Select yearSelect = new Select(element);
        yearSelect.selectByValue(value);
    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void fillElementWithEnter(WebElement element, String value) {
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void displayTextElement(WebElement element) {
        System.out.println("Textul din element este: " + element.getText());
    }

    public void findElement(List<WebElement> findElementList, String value) {
        for (int i = 0; i < findElementList.size(); i++) {
            if (findElementList.get(i).getText().equals(value)) {
                clickOnElements(findElementList.get(i));
                break;
            }
        }
    }

    public void checkMultipleElementsByListOfValues(List<WebElement> elements, List<String> values) {
        for (String value : values) {
            for (WebElement element : elements) {
                if (element.getText().equals(value)) {
                    element.click();
                    break;
                }
            }
        }
    }

    public void uploadPicture(WebElement element) {
        String pictureFilePath = "src/test/resources/1.png";
        File file = new File(pictureFilePath);
        element.sendKeys(file.getAbsolutePath());
    }

    public void fillWithActions(WebElement webElement, String value) {
        //clasa actions functioneaza cand identificam elementul dupa xpath
        actions.sendKeys(value).perform();
        //merge si cu build.perform
        waitVisibilityElement(webElement);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void fillMultipleValues(WebElement element, List<String> values) {
        //functioneaza cand identificam elementul dupa id
        for (String value : values) {
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
        }
    }

    public void waitVisibilityElement(WebElement element) {
        //definim un wait explicit ca sa astepte dupa element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
