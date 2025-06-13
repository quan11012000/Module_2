package test_thi.repository;

import test_thi.entity.Student;
import test_thi.entity.Teacher;
import test_thi.util.ReadWriterFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherRepository implements ITeacherRepository {
    private final String  PATH = "C:\\code_gym\\Module_2\\src\\test_thi\\data\\teacher.csv";
    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = new ArrayList<>();
        List<String> lines = ReadWriterFile.readCsvFile(PATH);
        for (String line : lines) {
            String[] fields = line.split(",");
            if(fields.length >=7) {
                teachers.add(new Teacher(
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
        return teachers;
    }

    @Override
    public boolean add(Teacher teacher) {
        ReadWriterFile.writeCsvFile(PATH, Collections.singletonList(teacher),true);
        return true;
    }

    @Override
    public boolean update(Teacher teacher) {
        List<Teacher> teachers = findAll();
        Teacher foundTeacher = findById(teacher.getId());
        for (int i = 0; i < teachers.size(); i++) {
            if (foundTeacher.getId() == teachers.get(i).getId()) {
                teachers.set(i, teacher);
                ReadWriterFile.writeCsvFile(PATH,teachers,false);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        List<Teacher> teachers = findAll();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                ReadWriterFile.writeCsvFile(PATH,teachers,false);
                return true;
            }
        }
        return false;
    }


    @Override
    public Teacher findById(int id) {
        List<Teacher> teachers = findAll();
        for (Teacher teacher : teachers) {
            if(teacher.getId() == id){
                return teacher;
            }
        }
        return null;
    }

    @Override
    public List<Teacher> findByName(String name) {
        List<Teacher> teachers = findAll();
        List<Teacher> result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getName().toLowerCase().contains(name.toLowerCase()) ) {
                result.add(teacher);
            }
        }
        return result;
    }
}
