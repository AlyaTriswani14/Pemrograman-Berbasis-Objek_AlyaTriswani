package academic.model;

/**
 * @author NIM Nama
 * @author NIM Nama
 */
public class Student {
    private String studentId;
    private String name;
    private int year;
    private String major;

    public Student(String studentId, String name, int year, String major) {
        this.studentId = studentId;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    @Override
    public String toString() {
        return studentId + "|" + name + "|" + year + "|" + major;
    }
}