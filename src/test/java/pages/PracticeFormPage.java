package pages;

import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        //astea e partea de driver.findElement
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameElement;

    @FindBy(id = "lastName")
    WebElement lastNameElement;

    @FindBy(id = "userEmail")
    WebElement userEmailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement mobileNumberElement;

    @FindBy(id = "uploadPicture")
    WebElement pictureElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherGenderElement;

    @FindBy(id = "currentAddress")
    WebElement addressElement;

    @FindBy(xpath = "//div[@id='state']//div[contains(@class, 'css-1hwfws3')]/*[1]")
    WebElement stateElement;

    @FindBy(xpath = "//div[@id='city']//div[contains(@class, 'css-1hwfws3')]/*[1]")
    WebElement cityElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readingHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicHobbyElement;

// identificarea dupa xpath functioneaza cu clasa fillWithActions
//    @FindBy(xpath = "//div[@id='subjectsContainer']")
//    WebElement subjectsElement;

    //identificarea dupa id functioneaza cu clasa fillMultipleValues
    @FindBy(id = "subjectsInput")
    WebElement subjectsElement;


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
