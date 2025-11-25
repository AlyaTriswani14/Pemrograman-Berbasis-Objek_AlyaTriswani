package academic.model;

/**
 * @author 12S23029 - Sintong Hutapea
 * @author 12S23038 - Alya Triswani
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Individu {
    private String year;
    private String major;

    public Student() {
        // Default constructor for JPA
    }

    public Student(String studentId, String studentName, String year, String major) {
        super(studentId, studentName);
        this.year = year;
        this.major = major;
    }

    @Id
    @Override
    public String getId() {
        return super.getId();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}