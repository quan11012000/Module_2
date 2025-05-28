package ss4_Oop.thuc_hanh.student.repository;

import ss4_Oop.thuc_hanh.student.model.Student;

import java.util.List;

public interface IStudentRepository extends IRepository<Student>{
    List<Student> sortByNameThenId(boolean ascending);
    List<Student> seachByName(String name);
}
