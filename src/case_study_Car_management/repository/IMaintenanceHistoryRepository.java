package case_study_Car_management.repository;

import case_study_Car_management.entity.MaintenanceHistory;

import java.util.List;

public interface IMaintenanceHistoryRepository {
    void add(MaintenanceHistory history);
    List<MaintenanceHistory> getByVehicleId(String vehicleId);
}
