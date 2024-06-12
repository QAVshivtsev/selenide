package ru.netology;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    public static String getDate(int daysAdd) {
        LocalDate currentDate = LocalDate.now().plusDays(daysAdd);
        return currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}