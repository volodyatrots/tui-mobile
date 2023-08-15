package com.company.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class ErrorMessages {
    @CsvBindByName(column = "error")
    private String error;
    @CsvBindByName(column = "message")
    private String message;

}