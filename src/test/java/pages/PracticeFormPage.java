package pages;

import objectData.PracticeFormObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends CommonPage {

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "userEmail")
    private WebElement userEmailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileNumberElement;

    @FindBy(id = "uploadPicture")
    private WebElement pictureElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement otherGenderElement;

    @FindBy(id = "currentAddress")
    private WebElement addressElement;

    @FindBy(xpath = "//div[@id='state']//div[contains(@class, 'css-1hwfws3')]/*[1]")
    private WebElement stateElement;

    @FindBy(xpath = "//div[@id='city']//div[contains(@class, 'css-1hwfws3')]/*[1]")
    private WebElement cityElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement sportHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement readingHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement musicHobbyElement;

    @FindBy(id = "submit")
    private WebElement submitElement;

// identificarea dupa xpath functioneaza cu clasa fillWithActions
//    @FindBy(xpath = "//div[@id='subjectsContainer']")
//  private  WebElement subjectsElement;

    //identificarea dupa id functioneaza cu clasa fillMultipleValues
    @FindBy(id = "subjectsInput")
    private WebElement subjectsElement;

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

    public void completeHobbies(PracticeFormObject practiceFormObject) {
        javascriptMethods.scroll(0, 400);
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(musicHobbyElement);
        hobbiesElement.add(readingHobbyElement);
        elementsMethods.checkMultipleElementsByListOfValues(hobbiesElement, practiceFormObject.getHobbies());
    }

    public void completeState(PracticeFormObject practiceFormObject) {
//        javascriptMethods.forceClick(stateElement);
        elementsMethods.clickOnElements(stateElement);
        elementsMethods.waitVisibilityElement(stateElement);
        elementsMethods.fillWithActions(stateElement, practiceFormObject.getState());
//        javascriptMethods.forceClick(cityElement);
        elementsMethods.clickOnElements(cityElement);
        elementsMethods.waitVisibilityElement(cityElement);
        elementsMethods.fillWithActions(cityElement, practiceFormObject.getCity());
    }

    public void submit() {
        submitElement.submit();
    }

}
