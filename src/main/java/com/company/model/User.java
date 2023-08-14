package com.company.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class User {
    @CsvBindByName(column = "userName")
    private String userName;
    @CsvBindByName(column = "email")
    private String userEmail;
    @CsvBindByName(column = "password")
    private String password;
    @CsvBindByName(column = "firstName")
    private String firstName;
    @CsvBindByName(column = "lastName")
    private String lastName;

}