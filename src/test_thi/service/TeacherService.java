package test_thi.service;

import test_thi.entity.Student;

import java.util.List;

public class TeacherService implements IStudentService {
    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public boolean add(Student student) {
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Student findById(int id) {
        return null;
    }
}
