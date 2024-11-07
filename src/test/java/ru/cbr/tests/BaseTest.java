package ru.cbr.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$;

public class BaseTest {

    SelenideElement popupCookies = $(".popup-cookies");
    SelenideElement popupCookiesConfirmButton = $(".popup-cookies .btn");

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.cbr.ru";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
    }

    public void clearCookies() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        if (popupCookies.exists() && popupCookies.isDisplayed())
            popupCookiesConfirmButton.click();
    }
}
