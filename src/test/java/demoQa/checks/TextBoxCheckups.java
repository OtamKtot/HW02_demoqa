package demoQa.checks;

import demoQa.pageObjects.TextBoxPage;

import static com.codeborne.selenide.Condition.text;

public class TextBoxCheckups {
    TextBoxPage textBoxPage = new TextBoxPage();

    public TextBoxCheckups checkNameOutput(String name) {
        textBoxPage.getNameOutput().shouldHave(text(name));
        return this;
    }

    public TextBoxCheckups checkEmailOutput(String email) {
        textBoxPage.getEmailOutput().shouldHave(text(email));
        return this;
    }

    public TextBoxCheckups checkCurrentAddressOutput(String currentAddress) {
        textBoxPage.getCurrentAddressOutput().shouldHave(text(currentAddress));
        return this;
    }

    public TextBoxCheckups checkPermanentAddressOutput(String permanentAddress) {
        textBoxPage.getPermanentAddressOutput().shouldHave(text(permanentAddress));
        return this;
    }
}