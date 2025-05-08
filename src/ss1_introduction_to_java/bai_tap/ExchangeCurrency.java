package ss1_introduction_to_java.bai_tap;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ExchangeCurrency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tien USD ");
        double USD = sc.nextDouble();
        double VND = USD*25500;
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat vnFormat = NumberFormat.getCurrencyInstance(vietnam);
        System.out.println("VND "+ vnFormat.format(VND));
    }
}
