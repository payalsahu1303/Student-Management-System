public class Student {
    int id;
    String name;
    int age;
    String course;

    public Student(int i, String n, int a, String c) {
        id = i;
        name = n;
        age = a;
        course = c;
    }

    public int getId() {
        return id;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAge(int a) {
        age = a;
    }

    public void setCourse(String c) {
        course = c;
    }

    public String toString() {
        return id + " | " + name + " | " + age + " | " + course;
    }
}
