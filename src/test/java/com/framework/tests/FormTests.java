package com.framework.tests;

import com.framework.base.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTests extends BaseTest { // Наследуемся от BaseTest

    @Test
    public void verifyFormSubmission() {
        WebDriver driver = getDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        // Переменные
        String firstName = "Нурмухаммед";
        String lastName = "Акынбекуулу";
        String email = "n.akynbekuulu@test.com";
        String mobile = "1234567890";
        String subject = "Maths";
        String address = "Грузия, Тбилиси, ул. Свободы, 1";

        // Заполнение полей (Interaction)
        driver.findElement(By.cssSelector("#firstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#lastName")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(email);

        // Выбор пола (Gender - Male)
        WebElement maleRadio = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", maleRadio);

        driver.findElement(By.cssSelector("#userNumber")).sendKeys(mobile);

        WebElement subjectsInput = driver.findElement(By.cssSelector("#subjectsInput"));
        subjectsInput.sendKeys(subject);
        subjectsInput.sendKeys(Keys.ENTER);

        WebElement musicCheckbox = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", musicCheckbox);

        driver.findElement(By.cssSelector("#currentAddress")).sendKeys(address);

        WebElement stateDropdown = driver.findElement(By.cssSelector("#state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateDropdown);

        stateDropdown.click();
        driver.findElement(By.xpath("//div[text()='NCR']")).click();

        driver.findElement(By.cssSelector("#city")).click();
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        WebElement modalTitle = driver.findElement(By.cssSelector("#example-modal-title"));
        Assert.assertTrue(modalTitle.isDisplayed(), "Модальное окно не отображено.");

        String studentName = driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td")).getText();
        Assert.assertEquals(studentName, firstName + " " + lastName, "ФИО не совпадает.");

        String studentEmail = driver.findElement(By.xpath("//td[text()='Student Email']/following-sibling::td")).getText();
        Assert.assertEquals(studentEmail, email, "Email не совпадает.");

        driver.findElement(By.cssSelector("#closeLargeModal")).click();
    }
}
