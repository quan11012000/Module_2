package test_thi.util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    // Prompt method with default
    private static String prompt(String message, String defaultValue) {
        System.out.printf("%s [%s]: ", message, defaultValue);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? defaultValue : input;
    }

    // inputInt with and without default
    public static int inputInt(String message, int defaultValue, int min, int max) {
        while (true) {
            try {
                String input = prompt(message, String.valueOf(defaultValue));
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.printf("Giá trị phải từ %d đến %d\n", min, max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    public static int inputInt(String message, int min, int max) {
        while (true) {
            try {
                System.out.printf("%s: ", message);
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.printf("Giá trị phải từ %d đến %d\n", min, max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    // inputLong
    public static long inputLong(String message, long defaultValue, long min, long max) {
        while (true) {
            try {
                String input = prompt(message, String.valueOf(defaultValue));
                long value = Long.parseLong(input);
                if (value < min || value > max) {
                    System.out.printf("Giá trị phải từ %d đến %d\n", min, max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dài hợp lệ.");
            }
        }
    }

    public static long inputLong(String message, long min, long max) {
        while (true) {
            try {
                System.out.printf("%s: ", message);
                String input = scanner.nextLine().trim();
                long value = Long.parseLong(input);
                if (value < min || value > max) {
                    System.out.printf("Giá trị phải từ %d đến %d\n", min, max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dài hợp lệ.");
            }
        }
    }

    // inputFloat
    public static float inputFloat(String message, float defaultValue, float min, float max) {
        while (true) {
            try {
                String input = prompt(message, String.valueOf(defaultValue));
                float value = Float.parseFloat(input);
                if (value < min || value > max) {
                    System.out.printf("Giá trị phải từ %.2f đến %.2f\n", min, max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }

    public static float inputFloat(String message, float min, float max) {
        while (true) {
            try {
                System.out.printf("%s: ", message);
                String input = scanner.nextLine().trim();
                float value = Float.parseFloat(input);
                if (value < min || value > max) {
                    System.out.printf("Giá trị phải từ %.2f đến %.2f\n", min, max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }

    // inputDouble
    public static double inputDouble(String message, double defaultValue, double min, double max) {
        while (true) {
            try {
                String input = prompt(message, String.valueOf(defaultValue));
                double value = Double.parseDouble(input);
                if (value < min || value > max) {
                    System.out.printf("Giá trị phải từ %.2f đến %.2f\n", min, max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }

    public static double inputDouble(String message, double min, double max) {
        while (true) {
            try {
                System.out.printf("%s: ", message);
                String input = scanner.nextLine().trim();
                double value = Double.parseDouble(input);
                if (value < min || value > max) {
                    System.out.printf("Giá trị phải từ %.2f đến %.2f\n", min, max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }

    // inputString
    public static String inputString(String message, String defaultValue, int minLength, int maxLength) {
        while (true) {
            String input = prompt(message, defaultValue);
            if (input.length() < minLength || input.length() > maxLength) {
                System.out.printf("Độ dài phải từ %d đến %d ký tự\n", minLength, maxLength);
            } else {
                return input;
            }
        }
    }

    public static String inputString(String message, int minLength, int maxLength) {
        while (true) {
            System.out.printf("%s: ", message);
            String input = scanner.nextLine().trim();
            if (input.length() < minLength || input.length() > maxLength) {
                System.out.printf("Độ dài phải từ %d đến %d ký tự\n", minLength, maxLength);
            } else {
                return input;
            }
        }
    }
    // inputName - Không có default value
    public static String inputName(String message) {
        Pattern pattern = Pattern.compile("^[A-Za-zÀ-ỹ\\s]{4,45}$");
        while (true) {
            System.out.printf("%s: ", message);
            String input = scanner.nextLine().trim();
            if (!pattern.matcher(input).matches()) {
                System.out.println("Tên không hợp lệ. Chỉ nhập chữ và khoảng trắng, từ 4 đến 45 ký tự.");
            } else {
                return input;
            }
        }
    }

    // inputName - Có default value
    public static String inputName(String message, String defaultValue) {
        Pattern pattern = Pattern.compile("^[A-Za-zÀ-ỹ\\s]{4,45}$");
        while (true) {
            String input = prompt(message, defaultValue);
            if (!pattern.matcher(input).matches()) {
                System.out.println("Tên không hợp lệ. Chỉ nhập chữ và khoảng trắng, từ 4 đến 45 ký tự.");
            } else {
                return input;
            }
        }
    }

    // inputDate
    public static LocalDate inputDate(String message, LocalDate defaultValue, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        while (true) {
            String input = prompt(message + " (" + pattern + ")", defaultValue.format(formatter));
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập đúng định dạng.");
            }
        }
    }

    public static LocalDate inputDate(String message, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        while (true) {
            System.out.printf("%s (%s): ", message, pattern);
            String input = scanner.nextLine().trim();
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập đúng định dạng.");
            }
        }
    }

    // inputEmail
    public static String inputEmail(String message, String defaultValue) {
        Pattern pattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        while (true) {
            String input = prompt(message, defaultValue);
            if (pattern.matcher(input).matches()) {
                return input;
            } else {
                System.out.println("Email không hợp lệ.");
            }
        }
    }

    public static String inputEmail(String message) {
        Pattern pattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        while (true) {
            System.out.printf("%s: ", message);
            String input = scanner.nextLine().trim();
            if (pattern.matcher(input).matches()) {
                return input;
            } else {
                System.out.println("Email không hợp lệ.");
            }
        }
    }

    // inputPhone
    public static String inputPhone(String message, String defaultValue) {
        Pattern pattern = Pattern.compile("^0\\d{9,10}$");
        while (true) {
            String input = prompt(message, defaultValue);
            if (pattern.matcher(input).matches()) {
                return input;
            } else {
                System.out.println("Số điện thoại không hợp lệ.");
            }
        }
    }

    public static String inputPhone(String message) {
        Pattern pattern = Pattern.compile("^0\\d{9,10}$");
        while (true) {
            System.out.printf("%s: ", message);
            String input = scanner.nextLine().trim();
            if (pattern.matcher(input).matches()) {
                return input;
            } else {
                System.out.println("Số điện thoại không hợp lệ.");
            }
        }
    }
}