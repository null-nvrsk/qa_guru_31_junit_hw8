package ru.cbr.pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FinOrgPage {

    public FinOrgPage openPage() {
        open("/finorg");
        return this;
    }

    public FinOrgPage selectFilterTypeOrganisation(String type) {
        $("#ui-id-1 button").click();
        $$(".open .filter-select_options label").find(text(type)).click();

        return this;
    }

    public FinOrgPage selectFilterActivityStatus(String status) {
        $("#ui-id-3 button").click();
        $$(".open .filter-select_options label").find(text(status)).click();

        return this;
    }

    public void clickSearchButton() {
        $("#searchBtn").click();
    }

    public FinOrgPage verifyResultNotEmpty() {
        $$("#resultTable tbody tr").shouldBe(sizeGreaterThan(0));

        return this;
    }
}
