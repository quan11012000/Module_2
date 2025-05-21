package ss9_TDD.bai_tap.fizz_buzz;

public class FizzBuzz {
    public static String translate(int number){


        if(number % 3 == 0 && number % 5 ==0 ){
            return "FizzBuzz";
        }else if(number % 3 == 0){
            return "Fizz";
        }else if(number % 5 == 0){
            return "Buzz";
        }else return numberIntoWords(number);

    }
    private static String numberIntoWords(int number){
        String[] unit = {"khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam","chin"};
        String result="";
        while (number>0){
            if(number/10 ==0){
                result+=unit[number%10];
            }else {
                result += unit[number/10];
                result += " "+unit[number%10];

            }
            number = number/100;


        }
        return result;
    }
}
