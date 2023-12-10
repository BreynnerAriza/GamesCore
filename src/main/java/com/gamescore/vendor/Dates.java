package com.gamescore.vendor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {

    public static LocalDate parseLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }
}
