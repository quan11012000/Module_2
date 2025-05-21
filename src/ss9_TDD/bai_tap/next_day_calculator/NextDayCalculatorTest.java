package ss9_TDD.bai_tap.next_day_calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NextDayCalculatorTest {

    @Test
    void testNextDay_NormalDay() {
        assertEquals("2/1/2018", NextDayCalculator.findNextDay(1, 1, 2018));
    }

    @Test
    void testNextDay_EndOfMonth() {
        assertEquals("1/2/2018", NextDayCalculator.findNextDay(31, 1, 2018));
    }

    @Test
    void testNextDay_EndOf30DayMonth() {
        assertEquals("1/5/2018", NextDayCalculator.findNextDay(30, 4, 2018));
    }

    @Test
    void testNextDay_FebruaryNonLeapYear() {
        assertEquals("1/3/2018", NextDayCalculator.findNextDay(28, 2, 2018));
    }

    @Test
    void testNextDay_FebruaryLeapYear() {
        assertEquals("1/3/2020", NextDayCalculator.findNextDay(29, 2, 2020));
    }

    @Test
    void testNextDay_EndOfYear() {
        assertEquals("1/1/2019", NextDayCalculator.findNextDay(31, 12, 2018));
    }
}