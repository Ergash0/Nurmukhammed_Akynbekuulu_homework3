package com.framework.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    private WebDriver driver;

    private By alertWithTextBoxTab = By.cssSelector("a[href='#Textbox']");
    private By promptBoxButton = By.cssSelector("button[onclick='promptbox()']");
    private By resultText = By.cssSelector("#demo1");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAlertWithTextBoxTab() {
        driver.findElement(alertWithTextBoxTab).click();
    }

    public void clickPromptBoxButton() {
        driver.findElement(promptBoxButton).click();
    }

    public void enterTextInAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }
}
