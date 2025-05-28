package ss4_Oop.thuc_hanh.student.repository;

import ss4_Oop.thuc_hanh.student.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private final static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "Nguyen Van Minh", "C01"));
        students.add(new Student(2, "Tran Thi Hoa", "C02"));
        students.add(new Student(3, "Le Quoc Dat", "C01"));
        students.add(new Student(4, "Pham Tuan Anh", "C03"));
        students.add(new Student(5, "Nguyen Thi Mai", "C02"));
        students.add(new Student(6, "Hoang Van Long", "C01"));
        students.add(new Student(7, "Vu Thi Thu", "C03"));
        students.add(new Student(8, "Doan Thanh Son", "C02"));
        students.add(new Student(9, "Bui Ngoc Lan", "C03"));
        students.add(new Student(10, "Nguyen Van Minh", "C02"));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }


    @Override
    public void add(Student student) {
        students.add(student);
    }


    @Override
    public void remove(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    @Override
    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean isIdExist(int id) {
        if (findById(id) != null) {
            return true;
        } else return false;
    }

    @Override
    public List<Student> sortByNameThenId(boolean ascending) {
        List<Student> sortedList = new ArrayList<>(students);
        if (ascending==true) {
            sortedList.sort(Comparator.comparing(Student::getName).thenComparing(Student::getId));
        } else if(ascending==false) {
            sortedList.sort(Comparator.comparing(Student::getName).thenComparing(Student::getId).reversed());
        }else{
            System.out.println("khong tim thay lua chon");
        }
        return sortedList;
    }

    @Override
    public List<Student> seachByName(String name) {
        List<Student> seachList = new ArrayList<>();
        for (Student s : students){
            if(s.getName().contains(name)){
                seachList.add(s);
            }
        }
        return seachList;
    }
}

