package phone.model;

import phone.model.Contact;
public class HashTable {
    private final int SIZE = 100;
    private Contact[] table;

    public HashTable() {
        table = new Contact[SIZE];
    }

    private int hashFunction(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += (int) c;
        }
        return hash % SIZE;
    }

    public void addContact(String name, String phone) {
        int index = hashFunction(name);
        Contact newContact = new Contact(name, phone);

        if (table[index] == null) {
            table[index] = newContact;
        } else {
            Contact current = table[index];
            while (current != null) {
                if (current.name.equals(name)) {
                    current.phone = phone;
                    return;
                }
                if (current.next == null) break;
                current = current.next;
            }
            current.next = newContact;
        }
    }

    public String searchContact(String name) {
        int index = hashFunction(name);
        Contact current = table[index];

        while (current != null) {
            if (current.name.equals(name)) {
                return current.phone;
            }
            current = current.next;
        }
        return null;
    }
    public boolean deleteContact(String name) {
        int index = hashFunction(name);
        Contact current = table[index];
        Contact prev = null;
        while (current != null) {
            if (current.name.equals(name)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public Contact[] getTable() {
        return table;
    }
}