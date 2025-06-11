package case_study_Car_management.entity;

public enum MaintenanceType {
    PERIODIC_MAINTENANCE("Bảo dưỡng định kỳ", 5000, 800000),
    OIL_CHANGE("Thay dầu nhớt", 3000, 300000),
    BRAKE_CHECK("Kiểm tra phanh", 10000, 500000),
    TIRE_ROTATION("Xoay lốp", 8000, 200000),
    ENGINE_TUNE("Điều chỉnh động cơ", 15000, 1500000),
    BATTERY_CHECK("Kiểm tra ắc quy", 12000, 100000),
    AIR_FILTER("Thay lọc gió", 6000, 150000),
    COOLANT_CHANGE("Thay nước làm mát", 20000, 400000),
    TRANSMISSION("Bảo dưỡng hộp số", 25000, 2000000),
    EMERGENCY_REPAIR("Sửa chữa khẩn cấp", 0, 500000);

    private final String description;
    private final int recommendedKmInterval;
    private final double estimatedCost;

    MaintenanceType(String description, int recommendedKmInterval, double estimatedCost) {
        this.description = description;
        this.recommendedKmInterval = recommendedKmInterval;
        this.estimatedCost = estimatedCost;
    }

    public String getDescription() { return description; }
    public int getRecommendedKmInterval() { return recommendedKmInterval; }
    public double getEstimatedCost() { return estimatedCost; }
}