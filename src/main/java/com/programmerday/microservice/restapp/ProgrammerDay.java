package com.programmerday.microservice.restapp;

import org.springframework.lang.NonNull;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProgrammerDay {

    private int errorCode;
    private String dataMessage;

    public ProgrammerDay(@NonNull final String year) {
        int yearNumb;
        try {
            yearNumb = parseYear(year);
            if (yearNumb == 0) {
                this.errorCode = 2;
                this.dataMessage = "";
            } else {
                this.dataMessage = programmerDay(yearNumb);
                this.errorCode = 200;
            }
        } catch (NumberFormatException e) {
            this.dataMessage = "";
            this.errorCode = 1;
        }
    }

    private String programmerDay(int year) {
        int month = 0, day, daysNumb = 0, daysOfMonth = 0;
        final int DAYS_NUMB = 256;
        while (daysNumb <= DAYS_NUMB) {
            Calendar calendar = new GregorianCalendar();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            month++;
            daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            daysNumb += daysOfMonth;
        }
        day = DAYS_NUMB - (daysNumb - daysOfMonth);
        return "" + day + "/" + month + "/" + year;
    }

    private int parseYear(@NonNull final String year) throws NumberFormatException {
        int result;

        result = Integer.parseInt(year);
        if (result < 1000 || result >= 10000) {
            result = 0;
        }
        return result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getDataMessage() {
        return dataMessage;
    }
}
