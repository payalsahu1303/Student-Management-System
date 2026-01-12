import java.io.*;
import java.util.ArrayList;

public class StudentService {
    ArrayList<Student> students = new ArrayList<>();
    String file = "src/students.txt";

    public StudentService() {
        load();
    }

    void addStudent(Student s) {
        students.add(s);
        save();
        System.out.println("Student Added");
    }

    void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No Records");
            return;
        }
        System.out.println("\nID | Name | Age | Course");
        System.out.println("------------------------");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    void updateStudent(int id, String n, int a, String c) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(n);
                s.setAge(a);
                s.setCourse(c);
                save();
                System.out.println("Updated");
                return;
            }
        }
        System.out.println("Not Found");
    }

    void deleteStudent(int id) {
        boolean rem = students.removeIf(s -> s.getId() == id);
        if (rem) {
            save();
            System.out.println("Deleted");
        } else {
            System.out.println("Not Found");
        }
    }

    void save() {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(file))) {
            for (Student s : students) {
                w.write(s.id + "," + s.name + "," + s.age + "," + s.course);
                w.newLine();
            }
        } catch (Exception e) {
            System.out.println("Save Error");
        }
    }

    void load() {
        File f = new File(file);
        if (!f.exists())
            return;
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = r.readLine()) != null) {
                String[] d = line.split(",");
                students.add(new Student(Integer.parseInt(d[0]), d[1], Integer.parseInt(d[2]), d[3]));
            }
        } catch (Exception e) {
            System.out.println("Load Error");
        }
    }
}
