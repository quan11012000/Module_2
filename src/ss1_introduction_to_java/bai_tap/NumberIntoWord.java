package ss1_introduction_to_java.bai_tap;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class NumberIntoWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so : ");
        int number = sc.nextInt();

        String[] unit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] exception = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Niveteen"};
        String[] dozens = {"Twenty", "thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int numberUnit = number % 10;
        number = number / 10;
        int numberDozens = number % 10;
        number = number / 10;
        int dozensUnit=numberUnit+numberDozens*10;
        if (number != 0) {
            System.out.print(unit[number - 1] + " hundred ");

        }
        if(dozensUnit>9 && dozensUnit<20){
            System.out.print(exception[dozensUnit-10]);
        }else {
            if (numberDozens != 0) {
                System.out.print(dozens[numberDozens - 2] + " ");
            }
            if (numberUnit != 0) {
                System.out.println(unit[numberUnit - 1]);
            }
        }
    }

}
