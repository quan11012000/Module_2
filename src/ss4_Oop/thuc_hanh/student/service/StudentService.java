package ss4_Oop.thuc_hanh.student.service;

public class StudentService {
    private final StudentRepository repository = new StudentRepository();

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public void addStudent(Student student) {
        repository.save(student);
    }

    public Student getStudentById(int id) {
        return repository.findById(id);
    }

    public void deleteStudentById(int id) {
        repository.deleteById(id);
    }

    public List<Student> getStudentsSortedByNameAndId() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getName)
                        .thenComparing(Student::getId))
                .collect(Collectors.toList());
    }
}