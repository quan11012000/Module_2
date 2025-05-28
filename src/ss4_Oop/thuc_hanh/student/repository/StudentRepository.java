package ss4_Oop.thuc_hanh.student.repository;

public class StudentRepository {
    public class StudentRepository {
        private final List<Student> students = new ArrayList<>();

        public List<Student> findAll() {
            return new ArrayList<>(students);
        }

        public void save(Student student) {
            students.add(student);
        }

        public Student findById(int id) {
            for (Student s : students) {
                if (s.getId() == id) {
                    return s;
                }
            }
            return null;
        }

        public void deleteById(int id) {
            students.removeIf(s -> s.getId() == id);
        }
    }
}
