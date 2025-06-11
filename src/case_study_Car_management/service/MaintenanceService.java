package case_study_Car_management.service;


import case_study_Car_management.entity.Maintenance;
import case_study_Car_management.entity.MaintenanceStatus;
import case_study_Car_management.repository.MaintenanceRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MaintenanceService {
    private final MaintenanceRepository repo;
    private List<Maintenance> list;

    public MaintenanceService() {
        this.repo = new MaintenanceRepository();
        this.list = repo.loadAll();
    }

    public List<Maintenance> getAll() {
        return list;
    }

    public void add(Maintenance m) {
        list.add(m);
        repo.saveAll(list);
    }

    public Maintenance findById(String id) {
        return list.stream()
                .filter(m -> m.getMaintenanceId().equalsIgnoreCase(id))
                .findFirst().orElse(null);
    }

    public void update(Maintenance m) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaintenanceId().equals(m.getMaintenanceId())) {
                list.set(i, m);
                break;
            }
        }
        repo.saveAll(list);
    }

    public void delete(String id) {
        list.removeIf(m -> m.getMaintenanceId().equalsIgnoreCase(id));
        repo.saveAll(list);
    }

    public List<Maintenance> getOverdue() {
        return list.stream()
                .filter(Maintenance::isOverdue)
                .collect(Collectors.toList());
    }

    public List<Maintenance> getByStatus(MaintenanceStatus st) {
        return list.stream()
                .filter(m -> m.getStatus() == st)
                .collect(Collectors.toList());
    }
}