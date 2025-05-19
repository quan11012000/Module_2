package phone.view;

import phone.model.Contact;

public class PhoneBookView {
    public void showContact(String name, String phone) {
        System.out.println("Tên: " + name + " | SĐT: " + phone);
    }

    public void showNotFound(String name) {
        System.out.println("Không tìm thấy số điện thoại cho tên: " + name);
    }

    public void showAllContacts(Contact[] table) {
        for (Contact contact : table) {
            Contact current = contact;
            while (current != null) {
                showContact(current.name, current.phone);
                current = current.next;
            }
        }
    }

    public void showDeleted(String name) {
        System.out.println("Đã xóa số điện thoại của: " + name);
    }

    public void showDeleteFailed(String name) {
        System.out.println("Không tìm thấy để xóa: " + name);
    }
}