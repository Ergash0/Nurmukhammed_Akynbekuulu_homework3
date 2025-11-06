package com.framework.tests;

import com.framework.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest { // Наследуемся от BaseTest

    @Test
    public void verifyAlertWithTextBox() {
        WebDriver driver = getDriver();
        driver.get("https://demo.automationtesting.in/Alerts.html");

        String inputName = "Nurmukhammed_Akynbekuulu";

        driver.findElement(By.cssSelector("a[href='#Textbox']")).click();

        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys(inputName);

        alert.accept();

        WebElement resultElement = driver.findElement(By.cssSelector("#demo1"));
        String actualResultText = resultElement.getText();

        String expectedTextPart = "Hello " + inputName + " How are you today";

        Assert.assertTrue(actualResultText.contains(expectedTextPart),
                "Ожидаемый текст '" + expectedTextPart + "' не найден в результате: " + actualResultText);
    }
}