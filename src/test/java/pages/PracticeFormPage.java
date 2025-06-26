package pages;

import logger.LoggerUtility;
import objectData.PracticeFormObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends CommonPage {

    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")
    private WebElement tableStudentNameOutput;

    @FindBy(id = "userEmail")
    private WebElement userEmailElement;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")
    private WebElement tableEmailOutput;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement otherGenderElement;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")
    private WebElement tableGenderOutput;

    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileNumberElement;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")
    private WebElement tableMobileOutput;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearOfBirthElement;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthOfBirthElement;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")
    private WebElement tableBirthOutput;

    //identificarea dupa xpath functioneaza cu clasa fillWithActions
//      @FindBy(xpath = "//div[@id='subjectsContainer']")
//      private  WebElement subjectsElement;
//  //identificarea dupa id functioneaza cu clasa fillMultipleValues
    @FindBy(id = "subjectsInput")
    private WebElement subjectsElement;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")
    private WebElement tableSubjectsOutput;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement sportHobbyElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement readingHobbyElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement musicHobbyElement;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")
    private WebElement tableHobbiesOutput;

    @FindBy(id = "uploadPicture")
    private WebElement pictureElement;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")
    private WebElement tablePictureOutput;

    @FindBy(id = "currentAddress")
    private WebElement addressElement;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")
    private WebElement tableAddressOutput;

    @FindBy(xpath = "//div[@id='state']//div[contains(@class, 'css-1hwfws3')]/*[1]")
    private WebElement stateElement;
    @FindBy(xpath = "//div[@id='city']//div[contains(@class, 'css-1hwfws3')]/*[1]")
    private WebElement cityElement;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")
    private WebElement tableStateCityOutput;

    @FindBy(id = "submit")
    private WebElement submitElement;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void completeFirstRegion(PracticeFormObject practiceFormObject) {
        elementsMethods.fillElement(firstNameElement, practiceFormObject.getFirstName());
        elementsMethods.fillElement(lastNameElement, practiceFormObject.getLastName());
        elementsMethods.fillElement(userEmailElement, practiceFormObject.getEmail());
        elementsMethods.fillElement(addressElement, practiceFormObject.getAddress());
        elementsMethods.fillElement(mobileNumberElement, practiceFormObject.getMobileNo());
    }

    public void completeGender(PracticeFormObject practiceFormObject) {
        switch (practiceFormObject.getGender()) {
            case "Male":
                elementsMethods.clickOnElements(maleGenderElement);
                break;
            case "Female":
                elementsMethods.clickOnElements(femaleGenderElement);
                break;
            case "Other":
                elementsMethods.clickOnElements(otherGenderElement);
                break;
        }
    }

    public void completeSubject(String subject) {
        elementsMethods.clickOnElements(subjectsElement);
        //clasa actions.sendKeys astfel ca functioneaza cand identificam elementul dupa xpath
        elementsMethods.fillWithActions(subjectsElement, subject);
    }


    public void completeSubjectWithList(PracticeFormObject practiceFormObject) {
        elementsMethods.clickOnElements(subjectsElement);
        //foloseste element.sendKeys, astfel ca functioneaza atunci cand identificam webElementul dupa id
        elementsMethods.fillMultipleValues(subjectsElement, practiceFormObject.getSubjects());
    }

    public void completeDateOfBirth(PracticeFormObject practiceFormObject) {
        int dayOfBirth = Integer.parseInt(practiceFormObject.getDateOfBirth()[0]);
        int monthOfBirth = Integer.parseInt(practiceFormObject.getDateOfBirth()[1]);
        int yearOfBirth = Integer.parseInt(practiceFormObject.getDateOfBirth()[2]);

        elementsMethods.clickOnElements(dateOfBirthElement);
        LoggerUtility.infoLog("The user clicks on dateOfBirthElement");
        elementsMethods.selectByValue(yearOfBirthElement, String.valueOf(yearOfBirth));
        LoggerUtility.infoLog("The user selects the year");
        elementsMethods.selectByValue(monthOfBirthElement, String.valueOf(monthOfBirth - 1));
        LoggerUtility.infoLog("The user selects the month");
        javascriptMethods.scroll(0, 400);
        // TODO: refactor this - sa accepte orice date, nu doar cele >=10, din cauza formatului day-001 in xPath
        String dayOfBirthXPath = "//div[@class='react-datepicker__day react-datepicker__day--0" + dayOfBirth + " react-datepicker__day--weekend']";
        WebElement dayOfBirthElement = driver.findElement(By.xpath(dayOfBirthXPath));
        elementsMethods.clickOnElements(dayOfBirthElement);
        LoggerUtility.infoLog("The user selects the day");
    }

    public void uploadPicture() {
        elementsMethods.uploadPicture(pictureElement);
        LoggerUtility.infoLog("The user uploads a picture");
    }

    public void completeHobbies(PracticeFormObject practiceFormObject) {
        javascriptMethods.scroll(0, 400);
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        LoggerUtility.infoLog("The user adds Sport as hobby");
        hobbiesElement.add(musicHobbyElement);
        LoggerUtility.infoLog("The user adds Music as hobby");
        hobbiesElement.add(readingHobbyElement);
        LoggerUtility.infoLog("The user adds Reading as hobby");
        elementsMethods.checkMultipleElementsByListOfValues(hobbiesElement, practiceFormObject.getHobbies());
    }

    public void completeState(PracticeFormObject practiceFormObject) {
//        javascriptMethods.forceClick(stateElement);
        javascriptMethods.scroll(0, 400);
        elementsMethods.clickOnElements(stateElement);
        LoggerUtility.infoLog("The user clicks on State element");
        elementsMethods.waitVisibilityElement(stateElement);
        elementsMethods.fillWithActions(stateElement, practiceFormObject.getState());
//        javascriptMethods.forceClick(cityElement);
        elementsMethods.clickOnElements(cityElement);
        LoggerUtility.infoLog("The user clicks on City element");
        elementsMethods.waitVisibilityElement(cityElement);
        elementsMethods.fillWithActions(cityElement, practiceFormObject.getCity());
    }

    public void submit() {
        javascriptMethods.scroll(0, 400);
        submitElement.submit();
        LoggerUtility.infoLog("The user clicks on Submit button");
    }

    public void verifyValue(WebElement element, String expectedValue, String fieldName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedValue));
        String actualValue = element.getText().trim();

        Assert.assertEquals(actualValue, expectedValue,
                "❌ Value mismatch for field: " + fieldName + ". Expected: '" + expectedValue + "', Actual: '" + actualValue + "'"
        );
    }

    public void verifyListField(String actualFromUI, List<String> expectedList, String fieldName) {
        String actual = actualFromUI.trim();
        String expectedJoined = String.join(", ", expectedList).trim();

        Assert.assertEquals(
                actual,
                expectedJoined,
                "❌ Mismatch in field: " + fieldName + "\nExpected: " + expectedJoined + "\nActual: " + actual
        );
    }

    public WebElement getTableStudentNameOutput() {
        return tableStudentNameOutput;
    }

    public WebElement getTableEmailOutput() {
        return tableEmailOutput;
    }

    public WebElement getTableGenderOutput() {
        return tableGenderOutput;
    }

    public WebElement getTableMobileOutput() {
        return tableMobileOutput;
    }

    public WebElement getTableBirthOutput() {
        return tableBirthOutput;
    }

    public WebElement getTableSubjectsOutput() {
        return tableSubjectsOutput;
    }

    public WebElement getTableHobbiesOutput() {
        return tableHobbiesOutput;
    }

    public WebElement getTablePictureOutput() {
        return tablePictureOutput;
    }

    public WebElement getTableAddressOutput() {
        return tableAddressOutput;
    }

    public WebElement getTableStateCityOutput() {
        return tableStateCityOutput;
    }
}
