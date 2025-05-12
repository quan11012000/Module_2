package ss3_mang.bai_tap;

import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        int count=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap chuoi ");
        String str = sc.nextLine();
        System.out.println("Nhap ki tu");
        char chr = sc.nextLine().charAt(0);
        for(int i=0;i<str.length();i++){
            if(chr == str.charAt(i)){
                count++;
            }
        }
        System.out.printf("So lan xuat hien cua ki tu %c la : %d ",chr,count);
    }
}
