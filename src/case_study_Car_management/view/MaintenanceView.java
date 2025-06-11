package case_study_Car_management.view;
import case_study_Car_management.controller.MaintenanceController;
import case_study_Car_management.entity.Maintenance;
import case_study_Car_management.entity.MaintenanceStatus;
import case_study_Car_management.entity.MaintenanceType;
import case_study_Car_management.repository.MaintenanceRepository;
import case_study_Car_management.service.MaintenanceService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MaintenanceView {
    private final MaintenanceController ctrl;

    public MaintenanceView() {
        ctrl = new MaintenanceController();
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println("\n===== QUẢN LÝ BẢO DƯỠNG ====");
            System.out.println("1. Thêm mới");
            System.out.println("2. Hiển thị tất cả");
            System.out.println("3. Cập nhật trạng thái");
            System.out.println("4. Xóa");
            System.out.println("5. Hiển thị quá hạn");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextLine();

            switch (choice) {
                case "1": add(sc); break;
                case "2": showAll(); break;
                case "3": update(sc); break;
                case "4": delete(sc); break;
                case "5": showOverdue(); break;
                default: break;
            }
        } while (!choice.equals("0"));
    }

    private void add(Scanner sc) {
        System.out.print("Mã xe: ");
        String carId = sc.nextLine();

        System.out.println("Chọn loại:");
        MaintenanceType[] types = MaintenanceType.values();
        for (int i = 0; i < types.length; i++)
            System.out.printf("%d. %s\n", i + 1, types[i].getDescription());
        MaintenanceType type = types[Integer.parseInt(sc.nextLine()) - 1];

        System.out.print("Số km hiện tại: ");
        int mileage = Integer.parseInt(sc.nextLine());

        System.out.print("Ngày dự kiến (yyyy-MM-dd HH:mm): ");
        LocalDateTime scheduled = LocalDateTime.parse(sc.nextLine().replace(" ", "T"));

        if (ctrl.addNew(carId, type, mileage, scheduled))
            System.out.println("✅ Đã thêm!");
    }

    private void showAll() {
        List<Maintenance> list = ctrl.listAll();
        if (list.isEmpty()) System.out.println("Chưa có bản ghi!");
        else list.forEach(m -> System.out.println(m.toDisplayString()));
    }

    private void update(Scanner sc) {
        System.out.print("ID cần cập nhật: ");
        String id = sc.nextLine();
        Maintenance m = ctrl.listAll().stream()
                .filter(x -> x.getMaintenanceId().equalsIgnoreCase(id))
                .findFirst().orElse(null);
        if (m == null) { System.out.println("Không tìm thấy!"); return; }

        System.out.println("Trạng thái hiện tại: " + m.getStatus());
        System.out.println("Chọn trạng thái mới:");
        MaintenanceStatus[] statuses = MaintenanceStatus.values();
        for (int i = 0; i < statuses.length; i++)
            System.out.printf("%d. %s\n", i + 1, statuses[i].getDescription());
        MaintenanceStatus st = statuses[Integer.parseInt(sc.nextLine()) - 1];

        Double cost = null;
        String mech="", work="", notes="", parts="";
        if (st == MaintenanceStatus.COMPLETED) {
            System.out.print("Chi phí thực tế: "); cost = Double.parseDouble(sc.nextLine());
            System.out.print("Thợ: "); mech = sc.nextLine();
            System.out.print("Xưởng: "); work = sc.nextLine();
            System.out.print("Ghi chú: "); notes = sc.nextLine();
            System.out.print("Phụ tùng: "); parts = sc.nextLine();
        }

        if (ctrl.updateStatus(id, st, cost, mech, work, notes, parts))
            System.out.println("✅ Cập nhật thành công!");
    }

    private void delete(Scanner sc) {
        System.out.print("ID cần xóa: ");
        ctrl.delete(sc.nextLine());
        System.out.println("Đã xóa (nếu tồn tại).");
    }

    private void showOverdue() {
        List<Maintenance> list = ctrl.getOverdue();
        if (list.isEmpty()) System.out.println("Không có quá hạn!");
        else list.forEach(m -> System.out.println(m.toDisplayString()));
    }

}