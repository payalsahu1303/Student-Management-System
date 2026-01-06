import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
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
                    service.addStudent(new Student(id, name, age, course));
                }
                case 2 -> service.viewAllStudents();
                case 3 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String name = sc.nextLine();
                    System.out.print("New Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Course: ");
                    String course = sc.nextLine();
                    service.updateStudent(id, name, age, course);
                }
                case 4 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    service.deleteStudent(id);
                }
                case 5 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
