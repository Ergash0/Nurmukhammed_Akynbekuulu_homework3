package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.AlertPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {

    @Test(description = "Verify alert with text box works correctly")
    @Description("Test opens alert with textbox, sends input and verifies result message")
    public void verifyAlertWithTextBox() {
        // Используем getDriver() вместо driver
        getDriver().get("https://demo.automationtesting.in/Alerts.html");
        AlertPage alertPage = new AlertPage(getDriver());

        String inputName = "Nurmukhammed_Akynbekuulu";

        openAlertTab(alertPage);
        clickPromptButton(alertPage);
        sendTextToAlert(alertPage, inputName);

        String actualResult = alertPage.getResultText();
        String expectedText = "Hello " + inputName + " How are you today";

        Assert.assertTrue(actualResult.contains(expectedText),
                "Expected text '" + expectedText + "' was not found in: " + actualResult);
    }

    @Step("Open Alert with Text Box tab")
    public void openAlertTab(AlertPage page) {
        page.openAlertWithTextBoxTab();
    }

    @Step("Click Prompt Box button")
    public void clickPromptButton(AlertPage page) {
        page.clickPromptBoxButton();
    }

    @Step("Send text '{text}' to alert")
    public void sendTextToAlert(AlertPage page, String text) {
        page.enterTextInAlert(text);
    }
}
