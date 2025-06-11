package case_study_Car_management.repository;

import case_study_Car_management.entity.Maintenance;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceRepository {

        private final String filePath = "maintenance.csv";

        public List<Maintenance> loadAll() {
            List<Maintenance> list = new ArrayList<>();
            File file = new File(filePath);
            if (!file.exists()) return list;

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Maintenance m = Maintenance.fromFileString(line);
                    if (m != null) list.add(m);
                }
            } catch (Exception e) {
                System.err.println("Lỗi đọc CSV: " + e.getMessage());
            }
            return list;
        }

        public void saveAll(List<Maintenance> list) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
                for (Maintenance m : list) {
                    pw.println(m.toFileString());
                }
            } catch (Exception e) {
                System.err.println("Lỗi ghi CSV: " + e.getMessage());
            }
        }
    }

