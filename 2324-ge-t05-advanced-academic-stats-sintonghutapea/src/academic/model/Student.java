package academic.model;

/**
 * @author 12S23029 - Sintong Hutapea
 * @author 12S23038 - Alya Triswani
 */

 public class Student extends Individu{
    private String year;
    private String major;

    public Student(String studentId, String studentName, String year, String major) {
        super(studentId, studentName);
        this.year = year;
        this.major = major;
    }

    public String getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}