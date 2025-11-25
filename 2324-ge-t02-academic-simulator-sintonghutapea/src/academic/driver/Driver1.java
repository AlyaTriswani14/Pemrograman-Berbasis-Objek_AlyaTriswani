package academic.driver;

/**
 * @author NIM Nama
 * @author NIM Nama
 */
import academic.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] data = input.split("#");
            String code = data[0];
            String name = data[1];
            int credits = Integer.parseInt(data[2]);
            String grade = data[3];

            courses.add(new Course(code, name, credits, grade));
        }

        for (Course course : courses) {
            System.out.println(course);
        }
        scanner.close();
    }
}