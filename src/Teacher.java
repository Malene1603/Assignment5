import java.util.List;

// Teacher en en subclass til Person, så den arver metoder og atributter fra person.
// Deruover har Teacher 3 atributter mere som er initials, subject listen og salary.
public class Teacher extends Person {
    private String initials;
    private List<String> subjects;
    private double salary;

    //Konstruktøren
    public Teacher(int id, String name, String email, String initials, List<String> subjects) {
        super(id, name, email); // Kalder superclassens (Person) konstruktør
        this.initials = initials;
        this.subjects = subjects;
    }

    // toString metode, så Teacher objektet kan repræsenteres som en streng
    public String toString() {
        String mainSubject = subjects.isEmpty() ? "" : subjects.get(0); // Den gemmer lærens mainsubject, altså det fag der står på plads 0 i listen i mainSubject.
        String personInfo = super.toString(); // Kalder overklassens toString-metode for at gemme id, name og email i personinfo.
        return String.format("%-63s %-15s %s", personInfo, initials, mainSubject);
        // Retunerer en streng med alt hvad teacher indeholder
        // %-63s: Dette styrer formateringen af personInfo og sørger for, at det tager op til 63 tegn i bredden og er venstrejusteret.
        // %-15s: Dette styrer formateringen af initials og sørger for, at det tager op til 15 tegn i bredden og er venstrejusteret.
        // %s: Dette er pladsholderen for mainSubject, som vil blive indsat som en streng uden nogen specifik formatering.
    }

    // Sætter lærerens main subject, som er det første fag (plads 0) der står i subject listen hovedemnet.
    public void setMainSubject(String mainSubject) {
        subjects.add(0, mainSubject);
    }

    // Returnerer listen over de fag, læreren underviser i.
    public List<String> getSubjects() {
        return subjects;
    }

    // Returnerer lærerens initialer
    public String getInitials() {
        return initials;
    }

    // Returnerer lærerens løn
    public double getSalary() {
        return salary;
    }

    // Tilføjer et fag til teachers liste over fag de underviser i
    public void addSubject(String subject) {

    }

    // Sætter teachers løn
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
