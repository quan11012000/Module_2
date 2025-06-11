package case_study_Car_management.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Maintenance {
    private String maintenanceId;
    private String carId;
    private MaintenanceType type;
    private MaintenanceStatus status;
    private int currentMileage;
    private LocalDateTime scheduledDate;
    private LocalDateTime completedDate;
    private double actualCost;
    private String mechanicName;
    private String workshopName;
    private String notes;
    private String partsUsed;

    public Maintenance(String carId, MaintenanceType type, int currentMileage) {
        this.maintenanceId = "";
        this.carId = carId;
        this.type = type;
        this.status = MaintenanceStatus.SCHEDULED;
        this.currentMileage = currentMileage;
        this.scheduledDate = LocalDateTime.now();
    }

    public String getMaintenanceId() { return maintenanceId; }
    public String getCarId() { return carId; }
    public MaintenanceType getType() { return type; }
    public MaintenanceStatus getStatus() { return status; }
    public int getCurrentMileage() { return currentMileage; }
    public LocalDateTime getScheduledDate() { return scheduledDate; }
    public LocalDateTime getCompletedDate() { return completedDate; }
    public double getActualCost() { return actualCost; }
    public String getMechanicName() { return mechanicName; }
    public String getWorkshopName() { return workshopName; }
    public String getNotes() { return notes; }
    public String getPartsUsed() { return partsUsed; }

    public void setScheduledDate(LocalDateTime scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public void updateStatus(MaintenanceStatus status) {
        this.status = status;
    }

    public void completeMaintenance(double actualCost, String mechanicName, String workshopName,
                                    String notes, String partsUsed) {
        this.status = MaintenanceStatus.COMPLETED;
        this.completedDate = LocalDateTime.now();
        this.actualCost = actualCost;
        this.mechanicName = mechanicName;
        this.workshopName = workshopName;
        this.notes = notes;
        this.partsUsed = partsUsed;
    }

    public boolean isOverdue() {
        return status == MaintenanceStatus.SCHEDULED && scheduledDate.isBefore(LocalDateTime.now());
    }

    public String toFileString() {
        return String.join(",",
                maintenanceId,
                carId,
                type.name(),
                status.name(),
                String.valueOf(currentMileage),
                scheduledDate.toString(),
                completedDate != null ? completedDate.toString() : "",
                String.valueOf(actualCost),
                mechanicName != null ? mechanicName : "",
                workshopName != null ? workshopName : "",
                notes != null ? notes : "",
                partsUsed != null ? partsUsed : ""
        );
    }

    public static Maintenance fromFileString(String line) {
        try {
            String[] parts = line.split(",", -1);
            Maintenance m = new Maintenance(parts[1], MaintenanceType.valueOf(parts[2]), Integer.parseInt(parts[4]));
            m.maintenanceId = parts[0];
            m.status = MaintenanceStatus.valueOf(parts[3]);
            m.scheduledDate = LocalDateTime.parse(parts[5]);
            if (!parts[6].isEmpty()) m.completedDate = LocalDateTime.parse(parts[6]);
            m.actualCost = Double.parseDouble(parts[7]);
            m.mechanicName = parts[8];
            m.workshopName = parts[9];
            m.notes = parts[10];
            m.partsUsed = parts[11];
            return m;
        } catch (Exception e) {
            System.err.println("Không thể đọc dòng: " + line);
            return null;
        }
    }

    public String toDisplayString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("[%s] Xe: %s | Loại: %s | Trạng thái: %s | Ngày hẹn: %s",
                maintenanceId, carId, type.getDescription(), status.toString(), dtf.format(scheduledDate));
    }
}
