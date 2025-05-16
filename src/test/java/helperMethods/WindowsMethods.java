package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WindowsMethods {
    WebDriver driver;

    public WindowsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewTab(){
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
    }

    public void switchToPreviousTab(){
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(0));
    }

    public void switchToNewWindow(){
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
    }

    public void switchToPreviousWindow(){
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(0));
    }

    public void close(){
        driver.close();
    }

    public void displayContentOfNewTab(WebElement element){
        System.out.println("Textul din new tab este: " + element.getText());
    }

    public void displayContentOfNewWindow(WebElement element){
        System.out.println("Textul din new window este: " + element.getText());
    }


}
