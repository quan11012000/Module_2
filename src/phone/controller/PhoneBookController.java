package phone.controller;

import phone.model.Contact;
import phone.model.HashTable;
import phone.view.PhoneBookView;

public class PhoneBookController {
    private HashTable model;
    private PhoneBookView view;

    public PhoneBookController(HashTable model, PhoneBookView view) {
        this.model = model;
        this.view = view;
    }

    public void addContact(String name, String phone) {
        model.addContact(name, phone);
    }

    public void searchContact(String name) {
        String phone = model.searchContact(name);
        if (phone != null) {
            view.showContact(name, phone);
        } else {
            view.showNotFound(name);
        }
    }

    public void deleteContact(String name) {
        boolean success = model.deleteContact(name);
        if (success) {
            view.showDeleted(name);
        } else {
            view.showDeleteFailed(name);
        }
    }

    public void displayContacts() {
        view.showAllContacts(model.getTable());
    }
}