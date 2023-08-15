package com.company.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class User {
    @CsvBindByName(column = "name")
    private String userName;
    @CsvBindByName(column = "password")
    private String password;

}