package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends CommonPage{

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tableElements;
    @FindBy(id = "addNewRecordButton")
    private WebElement addNewRecordButtonElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    WebElement lastNameElement;
    @FindBy(id = "userEmail")
    WebElement emailElement;
    @FindBy(id = "age")
    WebElement ageElement;
    @FindBy(id = "salary")
    WebElement salaryElement;
    @FindBy(id = "department")
    WebElement departmentElement;
    @FindBy(id = "submit")
    WebElement submitButton;

    public WebTablePage(WebDriver driver) {
        super(driver);
    }
}
