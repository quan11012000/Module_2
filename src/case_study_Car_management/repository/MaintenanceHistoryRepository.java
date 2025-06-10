package case_study_Car_management.repository;

import case_study_Car_management.entity.MaintenanceHistory;

import java.util.List;

public class MaintenanceHistoryRepository implements IMaintenanceHistoryRepository{

    @Override
    public void add(MaintenanceHistory history) {

    }

    @Override
    public List<MaintenanceHistory> getByVehicleId(String vehicleId) {
        return null;
    }
}
