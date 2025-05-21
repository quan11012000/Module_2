package ss9_TDD.bai_tap.fizz_buzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    void numberIntoWordUnit(){
        String result = FizzBuzz.translate(2);
        assertEquals("hai",result);
    }
    @Test
    void numberIntoWord() {
        String result = FizzBuzz.translate(26);
       assertEquals("hai sau",result);
    }
    @Test
    void numberFizz3(){
        String result = FizzBuzz.translate(3);
        assertEquals("Fizz",result);
    }
    @Test
    void numberBuzz5(){
        String result = FizzBuzz.translate(5);
        assertEquals("Buzz",result);
    }
    @Test
    void numberFizzBuzz35(){
        String result = FizzBuzz.translate(15);
        assertEquals("FizzBuzz",result);
    }
}