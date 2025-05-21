package ss9_TDD.bai_tap.next_day_calculator;

import java.time.LocalDate;

public class NextDayCalculator {

    public static String findNextDay(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate nextDay = date.plusDays(1);
        return nextDay.getDayOfMonth() + "/" + nextDay.getMonthValue() + "/" + nextDay.getYear();
    }
}