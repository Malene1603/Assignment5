// Person er en abstract super class, der betyder at man ikke kan oprette person objekter.
// Den er der kun fordi den indeholder metoder og atributter som alle specialiseringer af personer indeholder.
// Den har 2 sub classer (Student og Teacher), som arver fra den.
// Person har 3 atributter som er id, name og email.
public abstract class Person {
    private int id;
    private String name;
    private String email;

    // Konstruktør
    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return String.format("%-11d %-27s %s", id, name, email);
        // Retunerer en streng med alt hvad student indeholder
        // %-11d: Dette angiver en venstrejusteret decimaltal (integer) med en bredde på 11 tegn for id.
        // %-27s: Dette angiver en venstrejusteret streng med en bredde på 27 tegn for name.
        // %s: Dette angiver en streng uden fast bredde for email.
    }

    //Returnerer id.
    public int getId() {
        return id;
    }

    // Returnerer name.
    public String getName() {
        return name;
    }

    // Returnerer email.
    public String getEmail() {
        return email;
    }

    // Sætter persons name.
    public void setName(String name) {
        this.name = name;
    }

    // Sætter persons email.
    public void setEmail(String email) {
        this.email = email;
    }
}
