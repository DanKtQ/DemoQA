package helperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class ElementsMethods {

    WebDriver driver;
    WebElement element;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElements(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void fillElementWithEnter(WebElement element, String value) {
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void fillMultipleValues(WebElement element, List<String> values){
        for (String value : values) {
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
        }
    }

    public void displayTextElement(WebElement element){
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
        for (String value: values) {
            for (WebElement element: elements) {
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

}
