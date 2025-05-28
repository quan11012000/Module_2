package ss4_Oop.thuc_hanh.student.repository;

import ss4_Oop.thuc_hanh.student.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final List<Student> students = new ArrayList<>();

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
        if (ascending) {
            sortedList.sort(Comparator.comparing(Student::getName).thenComparing(Student::getId));
        } else {
            sortedList.sort(Comparator.comparing(Student::getName).thenComparing(Student::getId).reversed());
        }
        return sortedList;
    }
}

