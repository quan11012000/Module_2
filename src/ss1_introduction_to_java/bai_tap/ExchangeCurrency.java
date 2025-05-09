package ss1_introduction_to_java.bai_tap;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ExchangeCurrency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double USD;
        do {
            System.out.println("Nhap tien USD ");
             USD = sc.nextDouble();
        }while (USD<=0 || USD >10000000);

        final int RATE = 25500;

        double VND = USD*RATE  ;
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat vnFormat = NumberFormat.getCurrencyInstance(vietnam);
        System.out.println("VND "+ vnFormat.format(VND));
    }
}
