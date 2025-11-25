package academic.driver;

import academic.model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] data = input.split("#");
            String action = data[0];

            if (action.equals("student-add")) {
                String studentId = data[1];
                String name = data[2];
                double GPA = Double.parseDouble(data[3]);
                int credits = Integer.parseInt(data[4]);
                students.add(new Student(studentId, name, GPA, credits));
            } else if (action.equals("student-best")) {
                int n = Integer.parseInt(data[1]);
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        if (Double.compare(s2.getGPA(), s1.getGPA()) == 0) {
                            return s1.getStudentId().compareTo(s2.getStudentId());
                        }
                        return Double.compare(s2.getGPA(), s1.getGPA());
                    }
                });
                for (int i = 0; i < n && i < students.size(); i++) {
                    System.out.println(students.get(i));
                }
            } else if (action.equals("student-show-all")) {
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        }

        scanner.close();
    }
}