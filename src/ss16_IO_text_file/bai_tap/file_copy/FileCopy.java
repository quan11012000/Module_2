package ss16_IO_text_file.bai_tap.file_copy;
import java.io.*;
import java.util.Scanner;
public class FileCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File sourceFile = getValidFile(sc, "Nhập đường dẫn tập tin nguồn: ", true);
        File targetFile = getValidFile(sc, "Nhập đường dẫn tập tin đích: ", false);
        int charCount = 0;
        boolean appendMode=true ;
        int copyCount = countPreviousCopies(targetFile) + 1;
        try (
                FileReader reader = new FileReader(sourceFile);
                FileWriter writer = new FileWriter(targetFile, true)
        ) {
            if (appendMode) {
                writer.write(System.lineSeparator());
            }
            writer.write("Lần " + copyCount + System.lineSeparator());
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
                charCount++;
            }
            System.out.println(" Sao chép thành công!");
            System.out.println(" Tổng số ký tự đã sao chép: " + charCount);

        } catch (IOException e) {
            System.err.println(" Lỗi khi đọc hoặc ghi file: " + e.getMessage());
        }
    }
    public static int countPreviousCopies(File file) {
        int count = 0;
        if (!file.exists()) return 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Lần ")) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.err.println(" Lỗi khi đọc file để đếm số lần: " + e.getMessage());
        }

        return count;
    }
    public static File getValidFile(Scanner sc, String prompt, boolean mustExist) {
        while (true) {
            System.out.print(prompt);
            String path = sc.nextLine();
            File file = new File(path);
            try {
                if (mustExist) {
                    if (!file.exists()) {
                        throw new FileNotFoundException("Tập tin không tồn tại.");
                    }
                    new FileReader(file).close();
                } else {
                    if (!file.exists()) {
                        boolean created = file.createNewFile();
                        if (!created) {
                            throw new IOException("Không thể tạo file đích.");
                        }
                    }
                    new FileWriter(file, true).close();
                }
                return file;
            } catch (IOException e) {
                System.err.println(" Lỗi: " + e.getMessage() + " Vui lòng thử lại.");
            }
        }
    }
}