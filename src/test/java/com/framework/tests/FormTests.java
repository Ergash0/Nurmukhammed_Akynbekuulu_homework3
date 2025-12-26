package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.FormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTests extends BaseTest {

    @Test
    public void verifyFormSubmission() {

        FormPage formPage = new FormPage(getDriver());

        String firstName = "Nurmukhammed";
        String lastName = "Akynbekuulu";
        String email = "n.akynbekuulu@test.com";

        formPage.openForm();
        formPage.fillFirstName(firstName);
        formPage.fillLastName(lastName);
        formPage.fillEmail(email);
        formPage.selectMaleGender();
        formPage.fillMobile("1234567890");
        formPage.selectSubject("Maths");
        formPage.selectMusicHobby();
        formPage.fillAddress("Georgia, Tbilisi");
        formPage.selectStateAndCity();
        formPage.submitForm();

        Assert.assertTrue(formPage.isModalDisplayed(), "The modal window is not displayed.");
        Assert.assertEquals(formPage.getStudentName(),
                firstName + " " + lastName);
        Assert.assertEquals(formPage.getStudentEmail(), email);

        formPage.closeModal();
    }
}
