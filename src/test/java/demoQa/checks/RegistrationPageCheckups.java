package demoQa.checks;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPageCheckups {

    public RegistrationPageCheckups checkResult(String columnName, String expectedValue) {
        compareValueInTableResult(columnName, expectedValue);
        return this;
    }

    //проверка таблицы после сабмита

    private void compareValueInTableResult(String columnName, String expectedValue) {
        $x("//td[contains(text(), '" + columnName + "')]/following-sibling::td[1]")
                .shouldHave(text(expectedValue));
    }
}
