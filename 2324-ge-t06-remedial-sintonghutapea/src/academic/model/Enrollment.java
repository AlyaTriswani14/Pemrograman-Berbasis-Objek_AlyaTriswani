package academic.model;

/**
 * @author 12S23029 - Sintong Hutapea
 * @author 12S23038 - Alya Triswani
 */

 public class Enrollment {
    private String courseCode;
    private String studentId;
    private String academicYear;
    private String semester;
    private String grade;
    private String previousGrade;
    private boolean isRemedialDone;

    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None";
        this.previousGrade = "None";
        this.isRemedialDone = false;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
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

    @Override
    public String toString() {
        if (previousGrade.equals("None")) {
            return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
        } else {
            return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade + "(" + previousGrade + ")";
        }
    }
}