package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import sharedData.Hooks;

import java.util.List;


public class WebTableTest extends Hooks {
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void browserWebTableTests() {

        elementsMethods = new ElementsMethods(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());
        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.goToDesiredMenu("Elements");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters Elements menu");
        commonPage.goToDesiredSubMenu("Web Tables");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters Web Tables submenu");

        List<WebElement> tableElements = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int actualTableSize = tableElements.size();

        WebElement addNewRecordButton = getDriver().findElement((By.id("addNewRecordButton")));
        elementsMethods.clickOnElements(addNewRecordButton);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user adds new record");

        //declarare valori form
        String firstNameValue = "Dan";
        String lastNameValue = "Baicoianu";
        String emailValue = "dan@testtest.com";
        String ageValue = "35";
        String salaryValue = "1000";
        String departmentValue = "Engineering";

        WebElement firstNameField = getDriver().findElement((By.id("firstName")));
        elementsMethods.fillElement(firstNameField, firstNameValue);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills firstName");

        WebElement lastNameField = getDriver().findElement((By.id("lastName")));
        elementsMethods.fillElement(lastNameField, lastNameValue);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills lastName");

        WebElement emailField = getDriver().findElement((By.id("userEmail")));
        elementsMethods.fillElement(emailField, emailValue);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills email");

        WebElement ageField = getDriver().findElement((By.id("age")));
        elementsMethods.fillElement(ageField, ageValue);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills age");

        WebElement salaryField = getDriver().findElement((By.id("salary")));
        elementsMethods.fillElement(salaryField, salaryValue);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills salary");

        WebElement departmentField = getDriver().findElement((By.id("department")));
        elementsMethods.fillElement(departmentField, departmentValue);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills department");

        WebElement submitButton = getDriver().findElement((By.id("submit")));
        elementsMethods.clickOnElements(submitButton);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user presses submit button");

        WebElement firstNameColumn = getDriver().findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][1]"));
        Assert.assertEquals("Dan", firstNameColumn.getText());
        WebElement lastNameColumn = getDriver().findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][2]"));
        Assert.assertEquals("Baicoianu", lastNameColumn.getText());
        WebElement ageColumn = getDriver().findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        Assert.assertEquals("35", ageColumn.getText());
        WebElement userEmailColumn = getDriver().findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][4]"));
        Assert.assertEquals("dan@testtest.com", userEmailColumn.getText());
        WebElement salaryColumn = getDriver().findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][5]"));
        Assert.assertEquals("1000", salaryColumn.getText());
        WebElement departmentColumn = getDriver().findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][6]"));
        Assert.assertEquals("Engineering", departmentColumn.getText());


    }
}