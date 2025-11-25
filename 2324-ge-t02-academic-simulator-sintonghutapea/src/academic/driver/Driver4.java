package academic.driver;

/**
 * @author NIM Nama
 * @author NIM Nama
 */

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] data = input.split("#");
            String action = data[0];

            if (action.equals("course-add")) {
                String code = data[1];
                String name = data[2];
                int credits = Integer.parseInt(data[3]);
                String grade = data[4];
                courses.add(new Course(code, name, credits, grade));
            } else if (action.equals("student-add")) {
                String studentId = data[1];
                String name = data[2];
                int year = Integer.parseInt(data[3]);
                String major = data[4];
                students.add(new Student(studentId, name, year, major));
            } else if (action.equals("enrollment-add")) {
                String courseCode = data[1];
                String studentId = data[2];
                String academicYear = data[3];
                String semester = data[4];
                enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
            }
        }

        for (Course course : courses) {
            System.out.println(course);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
        scanner.close();
    }
}
