package academic.driver;

/**
 * @author NIM Nama
 * @author NIM Nama
 */
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] data = input.split("#");
            String courseCode = data[0];
            String studentId = data[1];
            String academicYear = data[2];
            String semester = data[3];

            enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
        scanner.close();
    }
}