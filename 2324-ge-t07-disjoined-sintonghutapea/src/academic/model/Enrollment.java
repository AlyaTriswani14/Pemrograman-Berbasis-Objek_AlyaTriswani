package academic.model;

/**
 * @author 12S23029 - Sintong Hutapea
 * @author 12S23038 - Alya Triswani
 */

public class Enrollment {
    private CourseOpening courseOpening;
    private String studentId;
    private String grade;
    private String previousGrade;
    private boolean isRemedialDone;

    public Enrollment(CourseOpening courseOpening, String studentId) {
        this.courseOpening = courseOpening;
        this.studentId = studentId;
        this.grade = "None";
        this.previousGrade = "None";
        this.isRemedialDone = false;
    }

    public String getCourseCode() {
        return courseOpening.getCourseCode();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        if (!this.grade.equals("None")) {
            this.previousGrade = this.grade;
        }
        this.grade = grade;
    }

    public String getPreviousGrade() {
        return previousGrade;
    }

    public boolean isRemedialDone() {
        return isRemedialDone;
    }

    public void setRemedialDone(boolean isRemedialDone) {
        this.isRemedialDone = isRemedialDone;
    }

    public String getAcademicYear() {
        return courseOpening.getAcademicYear();
    }

    public String getSemester() {
        return courseOpening.getSemester();
    }

    @Override
    public String toString() {
        return courseOpening.getCourseCode() + "|" + studentId + "|" + courseOpening.getAcademicYear() + "|" + courseOpening.getSemester() + "|" + grade + (previousGrade.equals("None") ? "" : "(" + previousGrade + ")");
    }
}
