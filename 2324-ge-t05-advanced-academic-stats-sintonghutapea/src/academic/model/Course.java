package academic.model;

import java.util.List;

/**
 * @author 12S23029 - Sintong Hutapea
 * @author 12S23038 - Alya Triswani
 */

 public class Course {
    private String courseCode;
    private String courseName;
    private String credits;
    private String passingGrade;
    private List<Lecturer> lecturerInitialList; 

    public Course(String courseCode, String courseName, String credits, String passingGrade, List<Lecturer> lecturerInitialList) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.passingGrade = passingGrade;
        this.lecturerInitialList = lecturerInitialList;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCredits() {
        return credits;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    public List<Lecturer> getLecturerList() {
        return lecturerInitialList;
    }

    public String toString() {
        return courseCode + "|" + courseName + "|" + credits + "|" + passingGrade + "|" + lecturerInitialList;
    }
}