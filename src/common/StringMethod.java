package common;

import java.util.Scanner;

public class StringMethod {
    public static String inputString(){
        Scanner scanner = new Scanner(System.in);
        String input;
        do{
            System.out.println("Nhập vào một chuỗi văn bản:");
            input = scanner.nextLine();
            if(!ValidateInput.isString(input)){
                System.out.println("nhap chuoi sai dinh dang");
            }
        }while(!ValidateInput.isString(input));
        return input;
    }
}
