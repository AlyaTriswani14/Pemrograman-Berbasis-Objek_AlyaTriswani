package academic.driver;

/**
 * @author 12S23029 - Sintong Hutapea
 * @author 12S23038 - Alya Triswani
 */

 import academic.model.Course;
 import academic.model.Student;
 import academic.model.Enrollment;
 import java.util.ArrayList;
 import java.util.Scanner;
 
 public class Driver1 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         ArrayList<Course> courses = new ArrayList<>();
         ArrayList<Student> students = new ArrayList<>();
         ArrayList<Enrollment> enrollments = new ArrayList<>();
 
         while (true) {
             String input = scanner.nextLine();
             if (input.equals("---")) break;
 
             String[] parts = input.split("#");
             if (parts.length > 1) {
                 switch (parts[0]) {
                     case "course-add":
                         if (parts.length == 5) {
                             boolean exists = courses.stream()
                                 .anyMatch(c -> c.getCourseCode().equals(parts[1]));
                             if (!exists) {
                                 Course course = new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                                 courses.add(course);
                             }
                         }
                         break;
                     case "student-add":
                         if (parts.length == 5) {
                             boolean exists = students.stream()
                                 .anyMatch(s -> s.getStudentId().equals(parts[1]));
                             if (!exists) {
                                 Student student = new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                                 students.add(student);
                             }
                         }
                         break;
                     case "enrollment-add":
                         if (parts.length == 5) {
                             boolean exists = enrollments.stream()
                                 .anyMatch(e -> e.getCourseCode().equals(parts[1]) && e.getStudentId().equals(parts[2]));
                             if (!exists) {
                                 Enrollment enrollment = new Enrollment(parts[1], parts[2], parts[3], parts[4]);
                                 enrollments.add(enrollment);
                             }
                         }
                         break;
                     default:
                         System.out.println("Unknown command!");
                 }
             }
         }
 
         courses.sort((c1, c2) -> c1.getCourseCode().compareTo(c2.getCourseCode()));
 
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