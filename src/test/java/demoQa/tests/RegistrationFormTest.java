package demoQa.tests;

import demoQa.checks.RegistrationPageCheckups;
import org.junit.jupiter.api.Test;
import demoQa.pageObjects.RegistrationPage;
import demoQa.components.CalendarComponent;

public class RegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationPageCheckups registrationCheckups = new RegistrationPageCheckups();

    @Test
    void successfulSearchTest() {
        //открываем страницу + сетим данные
        registrationPage.openPage()
                .setFirstName("Juzeppe")
                .setLastName("Fortunatti")
                .setUserEmail("JuzzForti@yopmail.com")
                .setGender("Male")
                .setUserMobileNumber("9998887777");
        //сетим DOB
        calendarComponent.setBirthDate("05", "January", "1988");

        registrationPage.subjectsInput("Arts")
                .setHobbies("Reading")
                .setAddress("Не дом и не улица. Мой адрес - Советский Союз!")
                .uploadFile("ONYX.png")
                .selectState("NCR")
                .selectCity("Delhi")
                .submitInformation();



        //чекап
        registrationCheckups
                .checkResult("Student Name", "Juzeppe Fortunatti")
                .checkResult("Student Email", "JuzzForti@yopmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9998887777")
                .checkResult("Date of Birth", "05 January,1988")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "ONYX.png")
                .checkResult("Address", "Не дом и не улица. Мой адрес - Советский Союз!")
                .checkResult("State and City", "NCR Delhi");

    }
}