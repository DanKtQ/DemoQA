package tests;

import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.TestBase;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends TestBase {

    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;
    PracticeFormPage practiceFormPage;

    @Test
    public void practiceFormTests() {
        elementsMethods = new ElementsMethods(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());
        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());

        homePage.goToDesiredMenu("Forms");
        commonPage.goToDesiredSubMenu("Practice Form");

        javascriptMethods.scrollDown(400);

        practiceFormPage.completeFirstRegion("Dan", "Baicoianu", "saknsa@gkdmfk.com", "Bucovina", "0988222333");
        practiceFormPage.completeGender("Other");

//        practiceFormPage.completeSubject("Maths");
        List<String> subject = new ArrayList<>();
        subject.add("Maths");
        subject.add("English");
        practiceFormPage.completeSubjectWithList(subject);

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Reading");
        hobbies.add("Music");
        practiceFormPage.completeHobbies(hobbies);

//        WebElement firstNameElement = driver.findElement((By.id("firstName")));
//        elementsMethods.fillElement(firstNameElement, "Dan");
//
//        WebElement lastNameElement = driver.findElement((By.id("lastName")));
//        elementsMethods.fillElement(lastNameElement, "Baicoianu");
//
//        WebElement emailElement = driver.findElement((By.id("userEmail")));
//        elementsMethods.fillElement(emailElement, "dasdnsd@skdsd.com");
//
//        WebElement genderMaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
//        WebElement genderFemaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
//        WebElement genderOtherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
//        List<WebElement> genderElements = new ArrayList<>();
//        genderElements.add(genderMaleElement);
//        genderElements.add(genderFemaleElement);
//        genderElements.add(genderOtherElement);
//
//        elementsMethods.findElement(genderElements, "Male");
//
//        WebElement mobileNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
//        elementsMethods.fillElement(mobileNumberElement, "0766555333");
//
//        //Date of Birth
//        String yearOfBirthValue = "1955";
//        String monthOfBirthValue = "August";
//        String dayOfBirthValue = "15";
//
//        WebElement dateOfBirthInputElement = driver.findElement(By.id("dateOfBirthInput"));
//        dateOfBirthInputElement.click();
//        javascriptMethods.scrollDown(400);
//
//        WebElement yearElement = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
//        elementsMethods.fillElement(yearElement, yearOfBirthValue);
//
//        WebElement monthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
//        elementsMethods.fillElement(monthElement, monthOfBirthValue);
//
//        String dayOfBirthXpath = "//div[@class='react-datepicker__day react-datepicker__day--0" + dayOfBirthValue + "']";
//        WebElement dayOfBirthElement = driver.findElement(By.xpath(dayOfBirthXpath));
//        elementsMethods.clickOnElements(dayOfBirthElement);
//
//        //Subjects:
//        List<String> subjectValues = new ArrayList<>();
//        subjectValues.add("Social Studies");
//        subjectValues.add("History");
//        subjectValues.add("Informatics");
//
//        WebElement subjectsInputElement = driver.findElement(By.id("subjectsInput"));
//        elementsMethods.fillMultipleValues(subjectsInputElement, subjectValues);
//
//        //Hobbies
//        List<String> hobbiesValues = new ArrayList<>();
//        hobbiesValues.add("Sports");
//        hobbiesValues.add("Chess");
//
//        WebElement hobbiesSportsElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
//        WebElement hobbiesReadingElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
//        WebElement hobbiesMusicElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
//        List<WebElement> hobbyElements = new ArrayList<>();
//        hobbyElements.add(hobbiesSportsElement);
//        hobbyElements.add(hobbiesReadingElement);
//        hobbyElements.add(hobbiesMusicElement);
//
////        elementsMethods.checkMultipleElementsByListOfValues(hobbyElements, hobbiesValues);
//
//        WebElement uploadPictureElement = driver.findElement(By.id("uploadPicture"));
//        elementsMethods.uploadPicture(uploadPictureElement);
//
//        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
//        String currentAddressValue =
//                "Covasna, Romania" + "\n" +
//                        "Line 2" + "\n" +
//                        "Line 3";
//        elementsMethods.fillElement(currentAddressElement, currentAddressValue);
//
//        //State
////        WebElement stateElement = driver.findElement(By.xpath("//div[@id='state']//div[contains(@class, 'css-1hwfws3')]/*[1]"));
////        //cand nu poti face click pe element(eg o reclama se suprapune) se poate folosi "the hammer"
////        //javascriptExecutor iti permite sa faci actiuni extra
////        javascriptMethods.forceClick(stateElement);
////        elementsMethods.fillElementWithEnter(stateElement, "NCR");
//
//        //City
//        WebElement cityElement = driver.findElement(By.xpath("//div[@id='city']//div[contains(@class, 'css-1hwfws3')]/*[1]"));
//        javascriptMethods.forceClick(cityElement);
////        elementsMethods.fillElementWithEnter(cityElement, "Delhi");
//        elementsMethods.fillElement(cityElement, "Delhi");
//
//        //Submit
//        WebElement submitElement = driver.findElement(By.id("submit"));
//        javascriptMethods.forceClick(submitElement);
    }
}
