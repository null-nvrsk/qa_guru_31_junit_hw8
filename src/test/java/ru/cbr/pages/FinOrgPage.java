package ru.cbr.pages;

import com.codeborne.selenide.SelenideElement;
import ru.cbr.models.CompanyInfo;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
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

    public FinOrgPage selectFilterRegion(String regionString) {
        $("#ui-id-4 button").click();
        $$(".open .filter-select_options label").find(text(regionString)).click();

        return this;
    }

    public FinOrgPage inputSearchPrase(String requestString) {
        $("#SearchPrase").setValue(requestString);

        return this;
    }

    public void clickSearchButton() {
        $("#searchBtn").click();
    }

    public FinOrgPage verifyResultNotEmpty() {
        $$("#resultTable tbody tr").shouldBe(sizeGreaterThan(0));

        return this;
    }

    public void verifyCompanyInformation(CompanyInfo expectedCompanyInfo) {
        SelenideElement foundINN = $(byTagAndText("td", expectedCompanyInfo.getINN()));
        SelenideElement foundRow = foundINN.closest("tr");
        SelenideElement foundCompanyName = foundRow.$$("td").get(0);
        SelenideElement foundOGRN = foundRow.$$("td").get(2);
        SelenideElement foundStatus = foundRow.$$("td").get(4);

        foundCompanyName.shouldHave(text(expectedCompanyInfo.getCompanyName()));
        foundOGRN.shouldHave(text(expectedCompanyInfo.getOGRN()));
        foundStatus.shouldHave(text(expectedCompanyInfo.getStatus()));
    }
}
