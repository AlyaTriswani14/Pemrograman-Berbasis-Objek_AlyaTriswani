package academic.model;

import javax.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_opening_id", nullable = false)
    private CourseOpening courseOpening;

    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "grade")
    private String grade;

    @Column(name = "previous_grade")
    private String previousGrade;

    @Column(name = "is_remedial_done")
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