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
                for (int i = 0;i<longEdge;i++){
                    for(int j=0;j<shortEdge;j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 2:
                System.out.println("Nhap canh cua tam giac :");
                int traingleEdge=sc.nextInt();
                for(int i=0;i<traingleEdge;i++){
                    for(int j=0;j<=i;j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 3:
                System.out.println("Nhap canh cua tam giac :");
                int traingleEdge1=sc.nextInt();
                for(int i=0;i<traingleEdge1;i++){
                    for(int j=traingleEdge1;j>i;j--){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
