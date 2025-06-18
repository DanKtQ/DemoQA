package tests;

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
        commonPage.goToDesiredSubMenu("Practice Form");

        practiceFormPage.completeFirstRegion(practiceFormObject);
        practiceFormPage.completeGender(practiceFormObject);

        practiceFormPage.completeSubjectWithList(practiceFormObject);

        practiceFormPage.completeHobbies(practiceFormObject);

        practiceFormPage.completeState(practiceFormObject);
        practiceFormPage.submit();
    }
}
