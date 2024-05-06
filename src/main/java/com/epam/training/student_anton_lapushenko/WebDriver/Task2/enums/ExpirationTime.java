package com.epam.training.student_anton_lapushenko.WebDriver.Task2.enums;

public enum ExpirationTime {
    Never("NEVER"), Burn_after_read("BURN AFTER READ"),
    TenMin("10 MIN"), OneHour("1 HOUR"), OneWeek("1 WEEK"),
    TwoWeeks("2 WEEKS"), OneMonth("1 MONTH"), TwoMonths("2 MONTHS"),
    SixMonths("6 MONTHS"), OneYear("1 YEAR");

    public final String text;

    ExpirationTime(String text) {
        this.text = text;
    }
}
