import java.io.*;
import java.util.*;


class Student implements Serializable {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "'}";
    }
}


class Course implements Serializable {
    private String code;
    private String title;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{code='" + code + "', title='" + title + "'}";
    }
}


class Enrollment implements Serializable {
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enrollment{" + student + ", " + course + "}";
    }
}


public class Task3Enrollment {
    public static void main(String[] args) {
        String filename = "enrollments.ser";


        Student s1 = new Student("S001", "Alice");
        Student s2 = new Student("S002", "Bob");

        Course c1 = new Course("C101", "Java Programming");
        Course c2 = new Course("C102", "Data Structures");

        List<Enrollment> enrollments = new ArrayList<>();
        enrollments.add(new Enrollment(s1, c1));
        enrollments.add(new Enrollment(s2, c2));


        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(enrollments);
            System.out.println("Enrollments saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving: " + e.getMessage());
        }


        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            List<?> readEnrollments = (List<?>) in.readObject();
            System.out.println("Enrollments read from file:");
            for (Object obj : readEnrollments) {
                System.out.println(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading: " + e.getMessage());
        }
    }
}

