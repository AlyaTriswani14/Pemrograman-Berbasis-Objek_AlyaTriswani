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
 
 public class Driver2 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         ArrayList<Course> courses = new ArrayList<>();
         ArrayList<Student> students = new ArrayList<>();
         ArrayList<Enrollment> enrollments = new ArrayList<>();
         ArrayList<String> errorMessages = new ArrayList<>();
 
         while (true) {
             String input = scanner.nextLine();
             if (input.equals("---")) break;
 
             String[] parts = input.split("#");
             if (parts.length > 1) {
                 try {
                     switch (parts[0]) {
                         case "course-add":
                             if (parts.length == 5) {
                                 if (courses.stream().noneMatch(c -> c.toString().startsWith(parts[1]))) {
                                     courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                                 }
                             }
                             break;
 
                         case "student-add":
                             if (parts.length == 5) {
                                 if (students.stream().noneMatch(s -> s.toString().startsWith(parts[1]))) {
                                     students.add(new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                                 }
                             }
                             break;
 
                         case "enrollment-add":
                             if (parts.length == 5) {
                                 Course course = courses.stream()
                                         .filter(c -> c.toString().startsWith(parts[1]))
                                         .findFirst()
                                         .orElse(null);
                                 if (course == null) {
                                     errorMessages.add("invalid course|" + parts[1]);
                                     break;
                                 }
 
                                 Student student = students.stream()
                                         .filter(s -> s.toString().startsWith(parts[2]))
                                         .findFirst()
                                         .orElse(null);
                                 if (student == null) {
                                     errorMessages.add("invalid student|" + parts[2]);
                                     break;
                                 }
 
                                 if (enrollments.stream().noneMatch(e -> e.toString().contains(parts[1]) && e.toString().contains(parts[2]))) {
                                     enrollments.add(new Enrollment(parts[1], parts[2], parts[3], parts[4]));
                                 }
                             }
                             break;
 
                         default:
                             errorMessages.add("Unknown command!");
                     }
                 } catch (Exception e) {
                     errorMessages.add("Error processing command: " + e.getMessage());
                 }
             }
         }
 
         courses.sort((c1, c2) -> c1.toString().compareTo(c2.toString()));
 
         for (String errorMessage : errorMessages) {
             System.out.println(errorMessage);
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
 