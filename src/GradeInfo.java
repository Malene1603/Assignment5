// Gradeinfo har 2 atributter, som er subject og grade.
public class GradeInfo {
    private String subject;
    private int grade;

    //Konstruktør
    public GradeInfo(String subject, int grade) {
        this.subject = subject;
        this.grade = grade;
    }

    // Retunerer en streng med alt hvad gradeinfo indeholder
    // Strengen indeholder fagets navn (subject) og karakteren (grade) i formatet: "Fag: Karakter".
    @Override
    public String toString() {
        return subject + ": " + grade;
    }

    //Returnerer subject.
    public String getSubject() {
        return subject;
    }

    // Returnerer grade.
    public double getGrade() {
        return grade;
    }
}
