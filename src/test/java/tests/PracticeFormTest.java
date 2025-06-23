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

        practiceFormPage.completeSubjectWithList(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user completes subjects ");

        practiceFormPage.completeHobbies(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user completes hobbies");

        practiceFormPage.completeState(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user completes state");
        practiceFormPage.submit();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user presses submit button");
    }
}
