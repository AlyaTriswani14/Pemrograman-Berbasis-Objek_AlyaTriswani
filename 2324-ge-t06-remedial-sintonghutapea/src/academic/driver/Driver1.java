package academic.driver;

/**
 * @author 12S23029 - Sintong Hutapea
 * @author 12S23038 - Alya Triswani
 */

 import java.util.Scanner;
 import java.util.ArrayList;
 import java.util.List;
 import academic.model.Lecturer;
 import academic.model.Student;
 import academic.model.Course;
 import academic.model.Enrollment;
 
 public class Driver1 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();

        String str;
        boolean isFinished = false;

        while(input.hasNext()){
            str = input.nextLine();

            if (str.equals("---")){
                isFinished = true;
                break;
            } else {
                String[] tokens = str.split("#");
                String command = tokens[0];

                if (command.equals("lecturer-add")) {
                    String NIDN = tokens[1];
                    String dosenName = tokens[2];
                    String initial = tokens[3];
                    String email = tokens[4];
                    String StudyProgram = tokens[5];

                    boolean isIDdosenExist = false;

                    for (Lecturer lecturer : lecturers){
                        if (lecturer.getId().equals(NIDN)){
                            isIDdosenExist = true;
                            break;
                        }
                    }

                    if(!isIDdosenExist){
                        Lecturer lecturer = new Lecturer(NIDN, dosenName, initial, email, StudyProgram);
                        lecturers.add(lecturer);
                    }
                }

                else if (command.equals("student-add")) {
                    String studentId = tokens[1];
                    String studentName = tokens[2];
                    String year = tokens[3];
                    String major = tokens[4];
                    boolean isIdExist = false;
                    for (Student student: students) {
                        if (student.getId().equals(studentId)) {
                            isIdExist = true;
                            break;
                        }
                    }
                    if (!isIdExist) {
                        Student student = new Student(studentId, studentName, year, major);
                        students.add(student);
                    }
                }

                else if (command.equals("enrollment-add")) {
                    String courseCode = tokens[1];
                    String studentId = tokens[2];
                    String academicYear = tokens[3];
                    String semester = tokens[4];
                
                    boolean isAlreadyEnrolled = false;
                
                    for (Enrollment enrollment : enrollments) {
                        if (enrollment.getCourseCode().equals(courseCode) &&
                            enrollment.getStudentId().equals(studentId) &&
                            enrollment.getAcademicYear().equals(academicYear) &&
                            enrollment.getSemester().equals(semester)) {
                            isAlreadyEnrolled = true;  
                            break;
                        }
                    }
                
                    if (!isAlreadyEnrolled) {
                        Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                        enrollments.add(enrollment);
                    }
                }
                

                else if (command.equals("course-add")) {
                    String courseCode = tokens[1];
                    String courseName = tokens[2];
                    String credits = tokens[3];
                    String passingGrade = tokens[4];
                    String lecturerInitialList = tokens[5];
                    boolean idCourseCodeExist = false;

                    for (Course course : courses) {
                        if (course.getCourseCode().equals(courseCode)) {
                            idCourseCodeExist = true;
                            break;
                        }
                    }
                    if (!idCourseCodeExist) {
                        String[] initials = lecturerInitialList.split(",");
                        List<Lecturer> courseLecturers = new ArrayList<>();

                        for (String initial : initials) {
                            for (Lecturer lecturer : lecturers) {
                                if (lecturer.getInitial().equals(initial.trim())) {
                                    courseLecturers.add(lecturer);
                                    break;
                                }
                            }
                        }

                        Course course = new Course(courseCode, courseName, credits, passingGrade, courseLecturers);
                        courses.add(course);
                    }
                }

                else if (command.equals("student-details")) {
                    String studentId = tokens[1];
                    Student student = null;
                
                    for (Student s : students) {
                        if (s.getId().equals(studentId)) {
                            student = s;
                            break;
                        }
                    }
                
                    if (student != null) {
                        double gpa = calculateGPA(studentId, enrollments, courses);
                        int totalCredits = calculateTotalCredits(studentId, enrollments, courses);
                
                        System.out.println(student.getId() + "|" + student.getName() + "|" +
                                student.getYear() + "|" + student.getMajor() + "|" + String.format("%.2f", gpa) + "|" + totalCredits);
                    }
                }

                else if (command.equals("enrollment-grade")) {
                    String courseCode = tokens[1];
                    String studentId = tokens[2];
                    String academicYear = tokens[3];
                    String semester = tokens[4];
                    String grade = tokens[5];
                    
                    for (Enrollment enrollment : enrollments) {
                        if (enrollment.getCourseCode().equals(courseCode) &&
                            enrollment.getStudentId().equals(studentId) &&
                            enrollment.getAcademicYear().equals(academicYear) &&
                            enrollment.getSemester().equals(semester)) {
                            enrollment.setGrade(grade); 
                            break;
                        }
                    }
                }  
                else if (command.equals("enrollment-remedial")) {
                    String courseCode = tokens[1];
                    String studentId = tokens[2];
                    String academicYear = tokens[3];
                    String semester = tokens[4];
                    String newGrade = tokens[5];

                    for (Enrollment enrollment : enrollments) {
                        if (enrollment.getCourseCode().equals(courseCode) &&
                            enrollment.getStudentId().equals(studentId) &&
                            enrollment.getAcademicYear().equals(academicYear) &&
                            enrollment.getSemester().equals(semester)) {
                            
                            if (!enrollment.getGrade().equals("None") && !enrollment.isRemedialDone()) {
                                enrollment.setGrade(newGrade);  
                                enrollment.setRemedialDone(true); 
                            }
                            break;
                        }
                    }
                }
            }
        }

        if (isFinished) {
            for(Lecturer lecturer : lecturers){
                System.out.println(lecturer.getId() + "|" + lecturer.getName() + "|" + lecturer.getInitial() + "|" + lecturer.getEmail() + "|" + lecturer.getStudyProgram());
            }

            for(Course course : courses){
                System.out.println(course.getCourseCode() + "|" + course.getCourseName() + "|" + course.getCredits() + "|" + course.getPassingGrade() + "|" + getLecturerList(course));
            }

            for(Student student : students){
                System.out.println(student.getId() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getMajor());
            }

            for (Enrollment enrollment : enrollments) {
                System.out.println(enrollment.toString());
            }
        }

        input.close();
    }

    private static String getLecturerList(Course course) {
        String lecturerList = "";
        List<Lecturer> lecturerInitialList = course.getLecturerList();
        for (int i = 0; i < lecturerInitialList.size(); i++) {
            Lecturer lecturer = lecturerInitialList.get(i);
            lecturerList += lecturer.getInitial() + " (" + lecturer.getEmail() + ")";
            if (i < lecturerInitialList.size() - 1) {
                lecturerList += ";";
            }
        }
        return lecturerList;
    }

    private static int calculateTotalCredits(String studentId, List<Enrollment> enrollments, List<Course> courses) {
        int totalCredits = 0;
        List<String> uniqueCourses = new ArrayList<>();
    
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId().equals(studentId)) {
                String courseCode = enrollment.getCourseCode();
                if (!uniqueCourses.contains(courseCode) && !enrollment.getGrade().equals("None")) {
                    Course course = null;
                    for (Course c : courses) {
                        if (c.getCourseCode().equals(courseCode)) {
                            course = c;
                            break;
                        }
                    }
                    if (course != null) {
                        totalCredits += Integer.parseInt(course.getCredits());
                        uniqueCourses.add(courseCode);
                    }
                }
            }
        }
    
        return totalCredits;
    }
    
    private static double calculateGPA(String studentId, List<Enrollment> enrollments, List<Course> courses) {
        double totalGradePoints = 0;
        int totalCredits = 0;
    
        List<String> courseCodes = new ArrayList<>();
        List<String> latestGrades = new ArrayList<>();
        List<Integer> courseCredits = new ArrayList<>();
    
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId().equals(studentId)) {
                String courseCode = enrollment.getCourseCode();
                String grade = enrollment.getGrade();
    
                if (!grade.equals("None")) {
                    int index = courseCodes.indexOf(courseCode);
                    if (index != -1) {
                        latestGrades.set(index, grade);
                    } else {
                        courseCodes.add(courseCode);
                        latestGrades.add(grade);
    
                        Course course = null;
                        for (Course c : courses) {
                            if (c.getCourseCode().equals(courseCode)) {
                                course = c;
                                break;
                            }
                        }
                        if (course != null) {
                            courseCredits.add(Integer.parseInt(course.getCredits()));
                        } else {
                            courseCredits.add(0); 
                        }
                    }
                }
            }
        }
    
        for (int i = 0; i < courseCodes.size(); i++) {
            String grade = latestGrades.get(i);
            totalCredits += courseCredits.get(i);
            totalGradePoints += getGradePoint(grade) * courseCredits.get(i);
        }
    
        if (totalCredits == 0) {
            return 0.0;  
        }
        return totalGradePoints / totalCredits;  
    }

    private static double getGradePoint(String grade) {
        switch (grade) {
            case "A": return 4.00;
            case "AB": return 3.50;
            case "B": return 3.00;
            case "BC": return 2.50;
            case "C": return 2.00;
            case "D": return 1.00;
            case "E": return 0.00;
            default: return 0.00;
        }
    }
}