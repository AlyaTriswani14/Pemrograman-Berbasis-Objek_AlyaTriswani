package academic.driver;

/**
 * @author NIM Nama
 * @author NIM Nama
 */
import academic.model.Student;
import java.util.ArrayList;
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
            String studentId = data[0];
            String name = data[1];
            int year = Integer.parseInt(data[2]);
            String major = data[3];

            students.add(new Student(studentId, name, year, major));
        }

        for (Student student : students) {
            System.out.println(student);
        }
        scanner.close();
    }
}