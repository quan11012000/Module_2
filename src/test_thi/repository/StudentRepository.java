package test_thi.repository;

import test_thi.entity.Student;
import test_thi.util.ReadWriterFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final String PATH = "C:\\code_gym\\Module_2\\src\\test_thi\\data\\student.csv";
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        List<String> lines = ReadWriterFile.readCsvFile(PATH);
        for (String line : lines) {
            String[] fields = line.split(",");
            if(fields.length >=7) {
                students.add(new Student(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        Integer.parseInt(fields[2]),
                        fields[3],
                        fields[4],
                        fields[5],
                        fields[6]
                ));
            }
        }
        return students;
    }

    @Override
    public boolean add(Student student) {
        ReadWriterFile.writeCsvFile(PATH, Collections.singletonList(student),true);
        return true;
    }

    @Override
    public boolean update(Student student) {
        List<Student> students = findAll();
        for (int i = 0; i < students.size(); i++) {
            if (student.getId() == students.get(i).getId()) {
                students.set(i, student);
                ReadWriterFile.writeCsvFile(PATH,students,false);
                return true;
            }
        }
        return false;
    }

    @Override
    public Student findById(int id) {
        List<Student> students = findAll();
        for (Student student : students) {
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> students = findAll();
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase()) ) {
                result.add(student);
            }
        }
        return result;
    }


    @Override
    public boolean delete(int id) {
        List<Student> students = findAll();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                ReadWriterFile.writeCsvFile(PATH,students,false);
                return true;
            }
        }
        return false;
    }
}
