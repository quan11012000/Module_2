package ss19_regex.bai_tap;

public class ValidateClassName {
        public static boolean isValidClassName(String className) {
            return className.matches("^[CAP]\\d{4}[GHIK]$");
        }
        public static void main(String[] args) {
            // Các ví dụ kiểm tra
            String[] testCases = {"C0223G", "A0323K", "M0318G", "P0323A", "C1234$", "C12G"};

            for (String test : testCases) {
                System.out.println(test + ": " + (isValidClassName(test) ? "Hợp lệ" : "Không hợp lệ"));
        }
    }
}
