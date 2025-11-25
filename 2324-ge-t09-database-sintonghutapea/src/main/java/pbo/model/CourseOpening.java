package academic.model;

import java.util.List;

/**
 * @author 12S23029 - Sintong Hutapea
 * @author 12S23038 - Alya Triswani
 */

public class CourseOpening {
    private Course course;
    private String academicYear;
    private String semester;
    private List<Lecturer> lecturers;

    public CourseOpening(Course course, String academicYear, String semester, List<Lecturer> lecturers) {
        this.course = course;
        this.academicYear = academicYear;
        this.semester = semester;
        this.lecturers = lecturers;
    }

    public String getCourseCode() {
        return course.getCourseCode();
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    @Override
    public String toString() {
        return course.getCourseCode() + "|" + course.getCourseName() + "|" + course.getCredits() + "|" + course.getPassingGrade() + "|" + academicYear + "|" + semester + "|" + getLecturerList();
    }

    private String getLecturerList() {
        StringBuilder lecturersList = new StringBuilder();
        for (int i = 0; i < lecturers.size(); i++) {
            lecturersList.append(lecturers.get(i).getInitial()).append(" (").append(lecturers.get(i).getEmail()).append(")");
            if (i < lecturers.size() - 1) {
                lecturersList.append(",");
            }
        }
        return lecturersList.toString();
    }
}