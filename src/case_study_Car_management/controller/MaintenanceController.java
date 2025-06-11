package case_study_Car_management.controller;

import case_study_Car_management.entity.Maintenance;
import case_study_Car_management.entity.MaintenanceStatus;
import case_study_Car_management.entity.MaintenanceType;
import case_study_Car_management.service.MaintenanceService;

import java.time.LocalDateTime;
import java.util.List;

public class MaintenanceController {
    private final MaintenanceService service;

    public MaintenanceController() {
        this.service = new MaintenanceService();
    }

    public List<Maintenance> listAll() {
        return service.getAll();
    }

    public boolean addNew(String carId, MaintenanceType type, int mileage, LocalDateTime scheduled) {
        try {
            Maintenance m = new Maintenance(carId, type, mileage);
            m.setScheduledDate(scheduled);
            service.add(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateStatus(String maintenanceId, MaintenanceStatus newStatus, Double actualCost,
                                String mechanicName, String workshopName, String notes, String partsUsed) {
        Maintenance m = service.findById(maintenanceId);
        if (m == null) return false;

        if (newStatus == MaintenanceStatus.COMPLETED && actualCost != null) {
            m.completeMaintenance(actualCost, mechanicName, workshopName, notes, partsUsed);
        } else {
            m.updateStatus(newStatus);
        }

        service.update(m);
        return true;
    }

    public boolean delete(String maintenanceId) {
        service.delete(maintenanceId);
        return true;
    }

    public List<Maintenance> getOverdue() {
        return service.getOverdue();
    }

    public List<Maintenance> getByStatus(MaintenanceStatus status) {
        return service.getByStatus(status);
    }
}