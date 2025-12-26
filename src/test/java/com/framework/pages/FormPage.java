package com.framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

    WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ===== Locator =====

    @FindBy(css = "#firstName")
    private WebElement firstNameInput;

    @FindBy(css = "#lastName")
    private WebElement lastNameInput;

    @FindBy(css = "#userEmail")
    private WebElement emailInput;

    @FindBy(css = "label[for='gender-radio-1']")
    private WebElement genderMale;

    @FindBy(css = "#userNumber")
    private WebElement mobileInput;

    @FindBy(css = "#subjectsInput")
    private WebElement subjectsInput;

    @FindBy(css = "label[for='hobbies-checkbox-3']")
    private WebElement musicCheckbox;

    @FindBy(css = "#currentAddress")
    private WebElement addressInput;

    @FindBy(css = "#state")
    private WebElement stateDropdown;

    @FindBy(xpath = "//div[text()='NCR']")
    private WebElement stateNCR;

    @FindBy(css = "#city")
    private WebElement cityDropdown;

    @FindBy(xpath = "//div[text()='Delhi']")
    private WebElement cityDelhi;

    @FindBy(css = "#submit")
    private WebElement submitButton;

    @FindBy(css = "#example-modal-title")
    private WebElement modalTitle;

    @FindBy(xpath = "//td[text()='Student Name']/following-sibling::td")
    private WebElement studentName;

    @FindBy(xpath = "//td[text()='Student Email']/following-sibling::td")
    private WebElement studentEmail;

    @FindBy(css = "#closeLargeModal")
    private WebElement closeModalButton;



    public void openForm() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void fillEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void selectMaleGender() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderMale);
    }

    public void fillMobile(String mobile) {
        mobileInput.sendKeys(mobile);
    }

    public void selectSubject(String subject) {
        subjectsInput.sendKeys(subject);
        subjectsInput.sendKeys(Keys.ENTER);
    }

    public void selectMusicHobby() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", musicCheckbox);
    }

    public void fillAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void selectStateAndCity() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateDropdown);
        stateDropdown.click();
        stateNCR.click();
        cityDropdown.click();
        cityDelhi.click();
    }

    public void submitForm() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }


    public boolean isModalDisplayed() {
        return modalTitle.isDisplayed();
    }

    public String getStudentName() {
        return studentName.getText();
    }

    public String getStudentEmail() {
        return studentEmail.getText();
    }

    public void closeModal() {
        closeModalButton.click();
    }
}
