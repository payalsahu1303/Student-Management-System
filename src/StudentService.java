import java.io.*;
import java.util.ArrayList;

public class StudentService {

    private final ArrayList<Student> students = new ArrayList<>();
    private final String FILE_NAME = "src/students.txt";

    public StudentService() {
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
        System.out.println("Student added successfully.");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\nID | Name | Age | Course");
        System.out.println("---------------------------");
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
                saveToFile();
                System.out.println("Student record updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            saveToFile();
            System.out.println("Student record deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getCourse());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error while saving student data.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists())
            return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                students.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3]));
            }
        } catch (IOException e) {
            System.out.println("Error while loading student data.");
        }
    }
}
