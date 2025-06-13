package test_thi.service;

import test_thi.entity.Student;
import test_thi.repository.IStudentRepository;
import test_thi.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean add(Student student) {
       return studentRepository.add(student);

    }

    @Override
    public boolean update(Student student) {
       return studentRepository.update(student);

    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);

    }

    @Override
    public Student findById(int id) {
       return studentRepository.findById(id);

    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }
}
