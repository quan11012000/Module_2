package case_study_Car_management.util;

import case_study_Car_management.module.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileUtil {
    public static List<String> readCsvFile(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            // file chưa tồn tại hoặc lỗi đọc
        }
        return list;
    }

    public static <T> void writeCsvFile(String path, List<String> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : list) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}