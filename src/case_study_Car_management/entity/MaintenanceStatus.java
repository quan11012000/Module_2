package case_study_Car_management.entity;

public enum MaintenanceStatus {
    SCHEDULED("Đã lên lịch", "📅"),
    IN_PROGRESS("Đang thực hiện", "🔧"),
    COMPLETED("Hoàn thành", "✅"),
    CANCELLED("Đã hủy", "❌"),
    OVERDUE("Quá hạn", "⚠️");

    private final String description;
    private final String icon;

    MaintenanceStatus(String description, String icon) {
        this.description = description;
        this.icon = icon;
    }

    public String getDescription() { return description; }
    public String getIcon() { return icon; }

    @Override
    public String toString() {
        return icon + " " + description;
    }
}
