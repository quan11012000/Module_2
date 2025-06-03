package ss19_regex.bai_tap;

import common.ValidateInput;

public class ValidateNumberPhone {
    public static void main(String[] args) {
        String[] numberPhone = {"84-0978489648", "84-22b22222", "84-9978489648"};
        for (String test : numberPhone) {
            System.out.println(test + ": " + (ValidateInput.isValidPhoneNumber(test) ? "Hợp lệ" : "Không hợp lệ"));
        }
    }
}
