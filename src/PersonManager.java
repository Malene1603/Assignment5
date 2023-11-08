import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonManager {

    // En privat liste til at gemme personobjekter, både students og teachers.
    private List<Person> persons = new ArrayList<>();

    // Konstruktør
    public PersonManager() {
        persons = new ArrayList<>();
    }

    // En metode til at hente hele listen af personer.
    public List<Person> getPersons() {
        return persons;
    }

    // En metode til at tilføje en person til listen.
    public void addPerson(Person person) {
        persons.add(person);
    }

    // En metode til at fjerne en person fra listen.
    public void removePerson(int id) {
        persons.remove(id);
    }

    // En metode til at hente en kopi af hele listen over personer.
    public List<Person> getAllPersons() {
        return new ArrayList<>(persons);
    }

    // En metode til at hente en liste over alle students fra person listen.
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (Person person : persons) {
            // Tjekker hver person i listen og tilføjer dem til student listen, hvis de er en student.
            if (person instanceof Student) {
                students.add((Student) person);
            }
        }
        return students;
    }

    // En metode til at hente en liste over alle teachers fra person listen.
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        for (Person person : persons) {
            // Tjekker hver person i listen og tilføjer dem til teacher listen, hvis de er en teacher.
            if (person instanceof Teacher) {
                teachers.add((Teacher) person);
            }
        }
        return teachers;
    }

    // En metode, der skulle være der i følge klassdiagramment.
    public void operation(){

    }
}
