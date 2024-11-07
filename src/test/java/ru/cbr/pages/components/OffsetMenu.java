package ru.cbr.pages.components;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;

public class OffsetMenu {

    public void openOffsetMenu() {
        $(".offsetMenu .home-header_content .header_menu").click();
    }

    public void clickQuickLinkByName(String menuItem) {
        $$(".menu_quick_links .inner_links a").find(exactText(menuItem)).click();
    }

    public void verifyOpenedByLinkPage(String menuItem, String pageUrl) {
        webdriver().shouldHave(urlStartingWith(Configuration.baseUrl + pageUrl));
        $("h1 span").shouldHave(text(menuItem));
    }
}
