package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import objectData.PracticeFormObject;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;
import propertyUtility.PropertyUtility;
import sharedData.Hooks;

public class PracticeFormTest extends Hooks {

    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;
    PracticeFormPage practiceFormPage;

    @Test
    public void practiceFormTests() {

        PropertyUtility propertyUtility = new PropertyUtility("PracticeFormTest");
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getData());

        elementsMethods = new ElementsMethods(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());
        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());

        homePage.goToDesiredMenu("Forms");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters Forms menu");
        commonPage.goToDesiredSubMenu("Practice Form");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters Practice Form submenu");

        practiceFormPage.completeFirstRegion(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user completes First Region");
        practiceFormPage.completeGender(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user completes Gender");

        practiceFormPage.completeDateOfBirth(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects the date of birth");

        practiceFormPage.completeSubjectWithList(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user completes subjects ");

        practiceFormPage.completeHobbies(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user completes hobbies");

        practiceFormPage.uploadPicture();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user uploads the picture");

        practiceFormPage.completeState(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user completes state");

        practiceFormPage.submit();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user presses submit button");

        elementsMethods.prepareForVerification();

        //Check the values
        practiceFormPage.verifyValue(practiceFormPage.getTableStudentNameLocator(), practiceFormObject.getFirstName() + " " +
                practiceFormObject.getLastName(), "Full Name");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user verifies OK the Student Name");
        practiceFormPage.verifyValue(practiceFormPage.getTableEmailLocator(), practiceFormObject.getEmail(), "Email");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user verifies OK the Email");
        practiceFormPage.verifyValue(practiceFormPage.getTableGenderLocator(), practiceFormObject.getGender(), "Gender");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user verifies OK the Gender");
        practiceFormPage.verifyValue(practiceFormPage.getTableMobileLocator(), practiceFormObject.getMobileNo(), "Mobile Number");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user verifies OK the Mobile Number");
        practiceFormPage.verifyValue(practiceFormPage.getTableBirthLocator(), practiceFormObject.getFormattedDateOfBirth(), "Date of Birth");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user verifies OK the Date of Birth");
        practiceFormPage.verifyListField(practiceFormPage.getFieldText(practiceFormPage.getTableSubjectsLocator()),practiceFormObject.getSubjects(),"Subjects");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user verifies OK the Subjects");
        practiceFormPage.verifyListField(practiceFormPage.getFieldText(practiceFormPage.getTableHobbiesLocator()),practiceFormObject.getHobbies(), "Hobbies");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user verifies OK the Hobbies");
        practiceFormPage.verifyValue(practiceFormPage.getTableAddressLocator(), practiceFormObject.getAddress(), "Address");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user verifies OK the Address");
        practiceFormPage.verifyValue(practiceFormPage.getTableStateCityLocator(), practiceFormObject.getState() + " " +
                practiceFormObject.getCity(), "State and City");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user verifies OK the State and City");

    }
}
