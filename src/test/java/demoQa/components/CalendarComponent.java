package demoQa.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
SelenideElement birthDate = $("#dateOfBirthInput");

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }
    public void setBirthDate(String day, String month, String year) {
        birthDate.click();
        setDate(day,month,year);
    }
}
