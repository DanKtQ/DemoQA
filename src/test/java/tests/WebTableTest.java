package tests;

import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import pages.CommonPage;
import pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebTableTest {
    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void browserWebTableTests() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //setam browserul in modul maximize
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        javascriptMethods = new JavascriptMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        homePage.goToDesiredMenu("Elements");
        commonPage.goToDesiredSubMenu("Web Tables");

        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int actualTableSize = tableElements.size();

        WebElement addNewRecordButton = driver.findElement((By.id("addNewRecordButton")));
        elementsMethods.clickOnElements(addNewRecordButton);

        //declarare valori form
        String firstNameValue = "Dan";
        String lastNameValue = "Baicoianu";
        String emailValue = "dan@testtest.com";
        String ageValue = "35";
        String salaryValue = "1000";
        String departmentValue = "Engineering";

        WebElement firstNameField = driver.findElement((By.id("firstName")));
        elementsMethods.fillElement(firstNameField, firstNameValue);

        WebElement lastNameField = driver.findElement((By.id("lastName")));
        elementsMethods.fillElement(lastNameField, lastNameValue);

        WebElement emailField = driver.findElement((By.id("userEmail")));
        elementsMethods.fillElement(emailField, emailValue);

        WebElement ageField = driver.findElement((By.id("age")));
        elementsMethods.fillElement(ageField, ageValue);

        WebElement salaryField = driver.findElement((By.id("salary")));
        elementsMethods.fillElement(salaryField, salaryValue);

        WebElement departmentField = driver.findElement((By.id("department")));
        elementsMethods.fillElement(departmentField, departmentValue);

        WebElement submitButton = driver.findElement((By.id("submit")));
        elementsMethods.clickOnElements(submitButton);

        WebElement firstNameColumn = driver.findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][1]"));
        assertEquals("Dan", firstNameColumn.getText());
        WebElement lastNameColumn = driver.findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][2]"));
        assertEquals("Baicoianu", lastNameColumn.getText());
        WebElement ageColumn = driver.findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        assertEquals("35", ageColumn.getText());
        WebElement userEmailColumn = driver.findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][4]"));
        assertEquals("dan@testtest.com", userEmailColumn.getText());
        WebElement salaryColumn = driver.findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][5]"));
        assertEquals("1000", salaryColumn.getText());
        WebElement departmentColumn = driver.findElement(By.xpath("//span[@id='edit-record-4']/ancestor::div[@class='rt-tr-group']//div[@class='rt-td'][6]"));
        assertEquals("Engineering", departmentColumn.getText());


    }
}