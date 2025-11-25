package academic.driver;
/**
 * @author NIM Nama
 * @author NIM Nama
 */
import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {

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
            } else if (action.equals("student-show-all")) {
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        }
        scanner.close();
    }
}
