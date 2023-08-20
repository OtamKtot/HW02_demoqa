package demoQa.tests;

import demoQa.checks.TextBoxCheckups;
import demoQa.pageObjects.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxCheckups textBoxChecks = new TextBoxCheckups();

    @Test
    void fillFormTest() {
        textBoxPage
                .openPage()
                .setUserName("Juzeppe Fortunati")
                .setEmail("JuzzForti@yopmail.com")
                .setCurrentAddress("current address")
                .setPermanentAddress("permanent address")
                .submitInformation();

        textBoxChecks
                .checkNameOutput("Juzeppe Fortunati")
                .checkEmailOutput("JuzzForti@yopmail.com")
                .checkCurrentAddressOutput("current address")
                .checkPermanentAddressOutput("permanent address");
    }
}
