package demoQa.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private SelenideElement
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            userCurrentAddress = $("#currentAddress"),
            userPermanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            nameOutput = $x("//div[@id='output']//*[@id='name']"),
            emailOutput = $x("//div[@id='output']//*[@id='email']"),
            currentAddressOutput = $x("//div[@id='output']//*[@id='currentAddress']"),
            permanentAddressOutput = $x("//div[@id='output']//*[@id='permanentAddress']");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userName.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        userCurrentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        userPermanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage submitInformation() {
        submitButton.click();
        return this;
    }

    public SelenideElement getNameOutput() {
        return nameOutput;
    }

    public SelenideElement getEmailOutput() {
        return emailOutput;
    }

    public SelenideElement getCurrentAddressOutput() {
        return currentAddressOutput;
    }

    public SelenideElement getPermanentAddressOutput() {
        return permanentAddressOutput;
    }
}
