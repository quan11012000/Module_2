package ss4_Oop.thuc_hanh.student.service;

import ss4_Oop.thuc_hanh.student.model.Student;

import java.util.List;

public interface IStudentService extends IService<Student> {
    List<Student> sortByNameThenId();
}
