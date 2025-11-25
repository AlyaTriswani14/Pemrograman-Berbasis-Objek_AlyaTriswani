package academic.model;
/**
 * @author NIM Nama
 * @author NIM Nama
 */
 public class Student {
     private String studentId;
     private String name;
     private double GPA;
     private int credits;
 
     public Student(String studentId, String name, double GPA, int credits) {
         this.studentId = studentId;
         this.name = name;
         this.GPA = GPA;
         this.credits = credits;
     }
 
     public String getStudentId() {
         return studentId;
     }
 
     public double getGPA() {
         return GPA;
     }
 
     @Override
     public String toString() {
         return studentId + "|" + name + "|" + GPA + "|" + credits;
     }
 }
 