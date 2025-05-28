package ss14_insertion_sort.sorting_advanced.model;

public class student {
    String name;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
