package ru.cbr.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.cbr.models.CompanyInfo;

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
    void searchFinOrgWithFilterByStatusTest(String status) {
        finOrgPage
                .selectFilterTypeOrganisation("Бюро кредитных историй")
                .selectFilterActivityStatus(status)
                .clickSearchButton();

        finOrgPage.verifyResultNotEmpty();
    }

    @DisplayName("Поиск организаций по неполному названию")
    @CsvFileSource(resources = "/data/finOrg.csv", delimiter = '\t', numLinesToSkip = 1)
    @ParameterizedTest(name = "Запрос \"{0}\" должен найти компанию {1} (ИНН/ОГРН {2}/{3}). Статус - {4}")
    @Tag("CBR-19")
    void checkByPartialNameOfTheOrganizationTest(
            String requestString,
            String companyName,
            String INN,
            String OGRN,
            String status
    ) {
        finOrgPage
                .inputSearchPrase(requestString)
                .clickSearchButton();

        CompanyInfo expectedCompanyInfo = new CompanyInfo(companyName, INN, OGRN, status);
        finOrgPage.verifyCompanyInformation(expectedCompanyInfo);
    }
}
