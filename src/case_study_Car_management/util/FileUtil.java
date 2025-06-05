package case_study_Car_management.util;

import case_study_Car_management.module.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void writeText(String path, List<Vehicle> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Vehicle vehicle : list) {
                bw.write(vehicle.getInfo());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Vehicle> readText(String path) {
        List<Vehicle> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                Vehicle vehicle = Vehicle.fromString(line);
                if (vehicle != null) list.add(vehicle);
            }
        } catch (IOException e) {
            // file chưa tồn tại hoặc lỗi đọc
        }
        return list;
    }
}
