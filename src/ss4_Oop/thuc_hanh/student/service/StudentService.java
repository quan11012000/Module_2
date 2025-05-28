package ss4_Oop.thuc_hanh.student.service;

import ss12_java_collection_framework.mvc.service.IProductService;
import ss4_Oop.thuc_hanh.student.model.Student;
import ss4_Oop.thuc_hanh.student.repository.IRepository;
import ss4_Oop.thuc_hanh.student.repository.IStudentRepository;
import ss4_Oop.thuc_hanh.student.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService implements IStudentService {
    IStudentRepository iRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return iRepository.findAll();
    }

    @Override
    public void add(Student student) {
        iRepository.add(student);
    }

    @Override
    public void remove(int id) {
        iRepository.remove(id);
    }

    @Override
    public Student findById(int id) {
        return iRepository.findById(id);
    }

    @Override
    public boolean isIdExist(int id) {
        return findById(id) != null;
    }

    @Override
    public List<Student> sortByNameThenId(boolean ascending) {
        return iRepository.sortByNameThenId(ascending);
    }
    @Override
    public List<Student> seachByName(String name) {
        return iRepository.seachByName(name);
    }
}