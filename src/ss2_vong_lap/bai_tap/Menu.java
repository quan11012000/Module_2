package ss2_vong_lap.bai_tap;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("chon loai hinh so : ");
        int order = sc.nextInt();
        switch (order){
            case 1:
                System.out.println("Nhap chieu dai cua hinh chu nhat :");
                int longEdge=sc.nextInt();
                System.out.println("Nhap chieu rong cua hinh chu nhat :");
                int shortEdge=sc.nextInt();
                for (int i = 0;i<shortEdge;i++){
                    for(int j=0;j<longEdge;j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 2:
                System.out.println("Nhap canh cua tam giac vuong botton-left :");
                int squareBottonLeft=sc.nextInt();
                for(int i=0;i<squareBottonLeft;i++){
                    for(int j=0;j<=i;j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 3:
                System.out.println("Nhap canh cua tam giac vuong top-left :");
                int squareTopLeft=sc.nextInt();
                for(int i=0;i<squareTopLeft;i++){
                    for(int j=squareTopLeft;j>i;j--){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 4:
                System.out.println("Nhap canh cua tam giac vuong top-right :");
                int squareTopRight=sc.nextInt();
                for(int i=0;i<squareTopRight;i++){
                    for(int k=0;k<i;k++){
                        System.out.print(" ");
                    }
                    for(int j=squareTopRight;j>i;j--){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 5:
                System.out.println("Nhap canh cua tam giac vuong botton-right :");
                int squareBottonRight=sc.nextInt();
                for(int i=0;i<squareBottonRight;i++){
                    for(int j=squareBottonRight;j>i;j--){
                        System.out.print("a");
                    }
                    for(int k=0;k<i;k++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 6:
                System.out.println("Nhap chieu cao tam giac can :");
                int height=sc.nextInt();
                for(int i=0;i<height;i++){
                    for(int j=0;j<height-i-1;j++){
                        System.out.print(" ");
                    }
                    for(int k = 0;k<=i*2;k++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
