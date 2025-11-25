package pbo.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author 12S23029 - Sintong Hutapea
 * @author 12S23038 - Alya Triswani
 */

@Entity
@Table(name = "courses")
public class Course {
    @Id
    private String courseCode;
    private String courseName;
    private int credits;
    private String passingGrade;

    @OneToMany(mappedBy = "course")
    private List<CourseOpening> courseOpenings;

    public Course(String courseCode, String courseName, int credits, String passingGrade) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.passingGrade = passingGrade;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    public List<CourseOpening> getCourseOpenings() {
        return courseOpenings;
    }

    @Override
    public String toString() {
        return courseCode + "|" + courseName + "|" + credits + "|" + passingGrade;
    }
}