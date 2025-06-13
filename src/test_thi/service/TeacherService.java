package test_thi.service;

import test_thi.entity.Student;
import test_thi.entity.Teacher;
import test_thi.repository.ITeacherRepository;
import test_thi.repository.TeacherRepository;

import java.util.List;

public class TeacherService implements ITeacherService {
    ITeacherRepository teacherRepository= new TeacherRepository();

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public boolean add(Teacher teacher) {
        return teacherRepository.add(teacher);
    }

    @Override
    public boolean update(Teacher teacher) {
        return teacherRepository.update(teacher);
    }

    @Override
    public boolean delete(int id) {
        return teacherRepository.delete(id);
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> findByName(String name) {
       return teacherRepository.findByName(name);
    }
}
