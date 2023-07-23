import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //сетим фио + эмейл
        $("#firstName").setValue("Juzeppe");
        $("#lastName").setValue("Fortunatti");
        $("#userEmail").setValue("JuzzForti@yopmail.com");
//        sleep(2000);

        //сетим пол + мобилу + DOB
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("9995558888");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $(".react-datepicker__day--005").click();
//        sleep(2000);

        //сетми интерес
        $x("//div[@id='subjectsContainer']//input").setValue("Arts").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();
//        sleep(2000);

        //сетим пикчу
        $("#uploadPicture").uploadFromClasspath("ONYX.PNG");
//        sleep(2000);

        //сетим адрес+штат+город
        $("#currentAddress").setValue("Не дом и не улица. Мой адрес - Советский Союз!");
//        sleep(2000);

        $x("//*[contains(text(), 'Select State')]").shouldBe(Condition.interactable)
                .scrollTo().click();
        $x("//*[contains(text(), 'NCR')]").shouldBe(Condition.interactable)
                .scrollTo().click();
        $x("//*[contains(text(), 'Select City')]").shouldBe(Condition.interactable)
                .scrollTo().click();
        $x("//*[contains(text(), 'Delhi')]").shouldBe(Condition.interactable)
                .scrollTo().click();
//        sleep(2000);

        //кликаем сабмит
        $x("//*[contains(text(), 'Submit')]").click();
//        sleep(2000);

        //проверка данных
        $x("//td[contains(text(), 'Student Name')]/following-sibling::td[1]")
                .shouldHave(exactText("Juzeppe Fortunatti"));
        $x("//td[contains(text(), 'Student Email')]/following-sibling::td[1]")
                .shouldHave(exactText("JuzzForti@yopmail.com"));
        $x("//td[contains(text(), 'Gender')]/following-sibling::td[1]").shouldHave(exactText("Male"));
        $x("//td[contains(text(), 'Mobile')]/following-sibling::td[1]")
                .shouldHave(exactText("9995558888"));
        $x("//td[contains(text(), 'Date of Birth')]/following-sibling::td[1]")
                .shouldHave(exactText("05 January,1988"));
        $x("//td[contains(text(), 'Subjects')]/following-sibling::td[1]").shouldHave(exactText("Arts"));
        $x("//td[contains(text(), 'Hobbies')]/following-sibling::td[1]").shouldHave(exactText("Music"));
        $x("//td[contains(text(), 'Picture')]/following-sibling::td[1]")
                .shouldHave(exactText("ONYX.PNG"));
        $x("//td[contains(text(), 'Address')]/following-sibling::td[1]")
                .shouldHave(exactText("Не дом и не улица. Мой адрес - Советский Союз!"));
        $x("//td[contains(text(), 'State and City')]/following-sibling::td[1]")
                .shouldHave(exactText("NCR Delhi"));
    }
}