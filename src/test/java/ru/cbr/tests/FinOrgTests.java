package ru.cbr.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Поиск организаций, участников финансового рынка")
public class FinOrgTests extends BaseTest {

    @BeforeEach
    void setUp() {
        open("/finorg");
    }

    @ValueSource(strings = {
            "Все", "действующий", "недействующий"
    })
    @DisplayName("Поиск организаций типа \"Бюро кредитных историй\" со статусом вида деятельности")
    @ParameterizedTest(name = "Со статусом вида деятельности \"{0}\" должен показать не пустой список")
    @Tag("CBR-20")
    void searchFinOrgWithFilterByStatus(String status) {
        finOrgPage
                .selectFilterTypeOrganisation("Бюро кредитных историй")
                .selectFilterActivityStatus(status)
                .clickSearchButton();

        finOrgPage.verifyResultNotEmpty();
    }

//    @CsvSource - CBR-19 Проверка по частичному названию организации ("ВТБ", "Альфа", "Петрокоммерц")
}
