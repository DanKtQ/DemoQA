package pages;

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

// identificarea dupa xpath functioneaza cu clasa fillWithActions
//    @FindBy(xpath = "//div[@id='subjectsContainer']")
//  private  WebElement subjectsElement;

    //identificarea dupa id functioneaza cu clasa fillMultipleValues
    @FindBy(id = "subjectsInput")
    private WebElement subjectsElement;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }


    public void completeFirstRegion(String firstName, String lastName, String email, String address, String mobileNo) {
        elementsMethods.fillElement(firstNameElement, firstName);
        elementsMethods.fillElement(lastNameElement, lastName);
        elementsMethods.fillElement(userEmailElement, email);
        elementsMethods.fillElement(addressElement, address);
        elementsMethods.fillElement(mobileNumberElement, mobileNo);
    }

    public void completeGender(String gender) {
        switch (gender) {
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


    public void completeSubjectWithList(List<String> list) {
        elementsMethods.clickOnElements(subjectsElement);
        //foloseste element.sendKeys, astfel ca functioneaza atunci cand identificam webElementul dupa id
        elementsMethods.fillMultipleValues(subjectsElement, list);
    }

    public void completeHobbies(List<String> hobbies) {
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(musicHobbyElement);
        hobbiesElement.add(readingHobbyElement);
        elementsMethods.checkMultipleElementsByListOfValues(hobbiesElement, hobbies);
    }

}
