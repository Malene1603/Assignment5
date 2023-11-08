import java.util.ArrayList;
import java.util.List;

// Student en en subclass til Person, så den arver metoder og atributter fra person.
// Deruover har Student 3 atributter mere som er education, gradeReport listen og averageGrade.
public class Student extends Person {
    private String education;
    private List<GradeInfo> gradeReport;
    private double averageGrade;

    // Konstruktør
    public Student(int id, String name, String email, String education) {
        super(id, name, email); // Kalder superclassens (Person) konstruktør
        this.education = education;
        this.gradeReport = new ArrayList<>();
        this.averageGrade = averageGrade;
    }

    // Retunerer Sgtudents gradeReport.
    public List<GradeInfo> getGradeReport() {
        return gradeReport;
    }

    // Retunerer Students education.
    public String getEducation() {
        return education;
    }

    // En metode til at tilføje karakterer til students gradeReport.
    public void addGrade(String subject, double grade) {
        gradeReport.add(new GradeInfo(subject, (int) grade));
    }

    @Override
    public String toString() {
        double averageGrade = calculateAverageGrade(); // Beregn den gennemsnitlige karakter (averageGrade) ved at kalde calculateAverageGrade-metoden.
        String personInfo = super.toString(); // Kalder overklassens toString-metode for at gemme id, name og email i personinfo.
        return String.format("%-63s %-15s %.1f", personInfo, education, averageGrade);
        // Retunerer en streng med alt hvad student indeholder
        // %-63s: Dette angiver en venstrejusteret streng med en bredde på 63 tegn for personInfo.
        // %-15s: Dette angiver en venstrejusteret streng med en bredde på 15 tegn for education.
        // %.1f: Dette angiver en decimaltal (float) med 1 decimal sted for averageGrade.
    }

    // En metode til at beregne den gennemsnitlige karakter for student.
    public double calculateAverageGrade() {
        double totalGrade = 0;
        for (GradeInfo grade : gradeReport) {
            totalGrade += grade.getGrade();
        }

        return totalGrade / gradeReport.size();
    }

    // Retunerer den gennemsnitlige karakter for student.
    public double getAverageGrade() {
        return averageGrade;
    }
}
