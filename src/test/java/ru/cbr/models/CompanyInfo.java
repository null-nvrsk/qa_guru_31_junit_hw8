package ru.cbr.models;

import lombok.Data;

@Data
public class CompanyInfo {

    String companyName;
    String INN;
    String OGRN;
    String status;

    public CompanyInfo(String companyName, String INN, String OGRN, String status) {
        this.companyName = companyName;
        this.INN = INN;
        this.OGRN = OGRN;
        this.status = status;
    }
}
