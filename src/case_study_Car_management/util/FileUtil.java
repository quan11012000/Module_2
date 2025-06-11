package case_study_Car_management.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> readCsvFile(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.isEmpty()){
                    list.add(line);
                }
            }
        } catch (IOException e) {
            // file chưa tồn tại hoặc lỗi đọc
        }
        return list;
    }

    public static void writeCsvFile(String path, List<String> list,boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,append))) {
            for (String line : list) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}