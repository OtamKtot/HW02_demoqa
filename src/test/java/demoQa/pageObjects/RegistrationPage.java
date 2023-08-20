package demoQa.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userMobileNumber = $("#userNumber"),
            subjectsInput = $x("//div[@id='subjectsContainer']//input"),
            hobbiesInput = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            uploadPictureInput = $("#uploadPicture"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityInput = $("#stateCity-wrapper"),
            submitButton = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserMobileNumber(String value) {
        userMobileNumber.setValue(value);
        return this;
    }

    public RegistrationPage subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage uploadFile(String classPath) {
        uploadPictureInput.uploadFromClasspath(classPath);
        return this;
    }

    public RegistrationPage selectState(String value) {
        stateInput.click();
        stateCityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectCity(String value) {
        cityInput.click();
        stateCityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submitInformation() {
        submitButton.click();
        return this;
    }
}