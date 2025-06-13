package test_thi.view;

import java.util.Scanner;

public class CommonView {
    private static Scanner sc = new Scanner(System.in);
    public static void showMessage(String message) {
        System.out.println("\n" + message);
    }

    public static void showError(String error) {
        System.out.println("\n[LOIX] " + error);
    }

    public static void showSuccess(String success) {
        System.out.println("\n[THANH CONG] " + success);
    }

    public static void pause() {
        System.out.print("\nNhan Enter de tiep tuc...");
        sc.nextLine();
    }
}
