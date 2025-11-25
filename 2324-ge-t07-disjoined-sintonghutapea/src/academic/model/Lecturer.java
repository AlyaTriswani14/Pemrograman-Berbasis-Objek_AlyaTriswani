package academic.model;

/**
 * @author 12S23029 - Sintong Hutapea
 * @author 12S23038 - Alya Triswani
 */

 public class Lecturer extends Individu{
    private String initial;
    private String email;
    private String studyProgram;

    public Lecturer(String NIDN, String dosenName, String initial, String email, String studyProgram) {
        super(NIDN, dosenName);
        this.initial = initial;
        this.email = email;
        this.studyProgram = studyProgram;
    }

    public String getInitial() {
        return initial;
    }

    public String getEmail() {
        return email;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public String toString() {
        return id + "|" + name + "|" + initial + "|" + email + "|" + studyProgram;
    }
}