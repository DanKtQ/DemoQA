package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWebPage extends CommonPage {

    @FindBy(id = "tabButton")
    private WebElement newTabButtonElement;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromNewTabElement;
    @FindBy(id = "windowButton")
    private WebElement newWindowButtonElement;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromNewWindowElement;

    public BrowserWebPage(WebDriver driver) {
        super(driver);
    }

    public void displayedTextFromNewTab()
    {
        elementsMethods.clickOnElements(newTabButtonElement);
        windowsMethods.switchToNewTab();
        elementsMethods.displayTextElement(sampleHeadingFromNewTabElement);
        windowsMethods.switchToPreviousTab();
    }
}
