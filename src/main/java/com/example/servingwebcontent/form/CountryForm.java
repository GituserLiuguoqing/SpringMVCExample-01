package com.example.servingwebcontent.form;

import lombok.Data;

@Data
public class CountryForm {


    private String mstcountrycd;
    private String mstcountrynanme;

    public CountryForm() {
    }

    public CountryForm(String mstcountrycd, String mstcountrynanme) {
        this.mstcountrycd = mstcountrycd;
        this.mstcountrynanme = mstcountrynanme;
    }
}

