import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void updateStudent(int id, String name, int age, String course) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setCourse(course);
                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
        System.out.println("Student deleted (if existed).");
    }
}
