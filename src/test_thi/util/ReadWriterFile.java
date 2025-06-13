package test_thi.util;

import test_thi.entity.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriterFile {
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
    public static <T extends Person> void writeCsvFile(String path, List<T> list , boolean append) {
        List<String> lines = new ArrayList<>();
        for (T item : list) {
            lines.add(item.toCsvLine());
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,append))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
