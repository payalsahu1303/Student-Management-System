import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService s = new StudentService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Management System (Console Based)");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int opt = sc.nextInt();
            sc.nextLine();

            if (opt == 1) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Course: ");
                String course = sc.nextLine();
                s.addStudent(new Student(id, name, age, course));
            } else if (opt == 2) {
                s.viewAllStudents();
            } else if (opt == 3) {
                System.out.print("ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("New Name: ");
                String name = sc.nextLine();
                System.out.print("New Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("New Course: ");
                String course = sc.nextLine();
                s.updateStudent(id, name, age, course);
            } else if (opt == 4) {
                System.out.print("ID to delete: ");
                int id = sc.nextInt();
                s.deleteStudent(id);
            } else if (opt == 5) {
                System.out.println("Exited");
                sc.close();
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }
}
