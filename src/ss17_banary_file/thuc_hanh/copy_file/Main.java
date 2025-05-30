package ss17_banary_file.thuc_hanh.copy_file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import static ss16_IO_text_file.bai_tap.file_copy.FileCopy.countPreviousCopies;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) throws Exception{
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    };
    private static void copyFileUsingStream(File source, File dest) throws Exception{
        int copyCount = countPreviousCopies(dest)+1;
        try(InputStream is = Files.newInputStream(source.toPath());
            OutputStream os = Files.newOutputStream(dest.toPath())) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    };
    private static int countPreviousCopies(File file) {
        int count = 0;
        if (!file.exists()) return 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("===== Lần ")) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đếm số lần sao chép: " + e.getMessage());
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter source file: ");
        String sourcePath =sc.nextLine();
        System.out.printf("Enter destination file:");
        String destPath = sc.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try{
            copyFileUsingStream(sourceFile,destFile);
            System.out.printf("copy completed");
        }catch (IOException ioe ){
            ioe.printStackTrace();
            System.out.println("Can't copy that file");
            System.out.println(ioe.getMessage());
        }
    }
}
