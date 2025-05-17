package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends CommonPage{

    @FindBy(id = "frame1")
    private WebElement frame1Element;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromFrame1Element;
    @FindBy(id = "frame2")
    private WebElement frame2Element;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromFrame2Element;

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void displayedTextFromFrame1(){
        framesMethods.switchToFrame(frame1Element);
        elementsMethods.displayTextElement(sampleHeadingFromFrame1Element);
        framesMethods.switchToMainContent();
    }

    public void displayedTextFromFrame2(){
        framesMethods.switchToFrame(frame2Element);
        elementsMethods.displayTextElement(sampleHeadingFromFrame2Element);
        framesMethods.switchToMainContent();
    }
}
