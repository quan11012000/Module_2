package case_study_Car_management.entity;

public class MaintenanceHistory {
    private String licensePlate;
    private String maintenanceDepartment;
    private String maintenanceDate;
    private double maintenanceFee;

    public MaintenanceHistory(String licensePlate, String maintenanceDepartment, String maintenanceDate,double maintenanceFee) {
        this.licensePlate = licensePlate;
        this.maintenanceDepartment = maintenanceDepartment;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceFee = maintenanceFee;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMaintenanceDepartment() {
        return maintenanceDepartment;
    }

    public void setMaintenanceDepartment(String maintenanceDepartment) {
        this.maintenanceDepartment = maintenanceDepartment;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public double getMaintenanceFee() {
        return maintenanceFee;
    }

    public void setMaintenanceFee(double maintenanceFee) {
        this.maintenanceFee = maintenanceFee;
    }
}
