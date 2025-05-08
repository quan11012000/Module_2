package ss1_introduction_to_java.thuc_hanh;
import java.util.Scanner;
public class HelloWorld {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.print(" Enter a number: ");
        int number = reader.nextInt();
        System.out.println("You entered:  " + number);
        int number2 = reader.nextInt();
        System.out.println("number2 " + number2);
        System.out.println(number2/number);
    }
}
