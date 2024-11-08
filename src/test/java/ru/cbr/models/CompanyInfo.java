package ru.cbr.models;

import lombok.Data;

@Data
public class CompanyInfo {
    public CompanyInfo(String companyName, String INN, String OGRN, String status) {
        this.companyName = companyName;
        this.INN = INN;
        this.OGRN = OGRN;
        this.status = status;
    }

    String companyName;
    String INN;
    String OGRN;
    String status;
}
