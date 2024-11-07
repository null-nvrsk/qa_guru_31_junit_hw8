package ru.cbr.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Проверка бокового меню")
public class OffsetMenuTests extends BaseTest {

    @BeforeEach
    void setUp() {
        open("/");
        offsetMenu.openOffsetMenu();
    }

    @DisplayName("В боковом меню 6 общих ссылок работают")
    @Tag("CBR-13")
    @CsvSource({
            "Меры защиты финансового рынка, /support_measures",
            "Новости, /news",
            "Решения Банка России, /rbr",
            "Контактная информация, /contacts",
            "Карта сайта, /sitemap",
            "О сайте, /about"
    })
    @ParameterizedTest(name = "При клике на\"{0}\" переходит на cbr.ru{1}")
    void offsetMenuQuickLinksTest(String menuItem, String pageUrl) {
        offsetMenu.clickQuickLinkByName(menuItem);
        offsetMenu.verifyOpenedByLinkPage(menuItem, pageUrl);
    }
}
