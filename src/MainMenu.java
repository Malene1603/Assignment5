import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// MainMenu en en subclass til Menu, så den arver metoder og atributter fra Menu.
// MainMenu har durover 3 atributter som er en students liste, en teachers liste og en scanner.
public class MainMenu extends Menu {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    //Konstruktør
    public MainMenu() {
        super("Main Menu", "Option 1 - Add a new student",
                "Option 2 - Add a new teacher",
                "Option 3 - Print a list of all students",
                "Option 4 - Print a list of all teachers",
                "Option 5 - Print a list of all persons",
                "Option 6 - Print a students gradereport by their id number",
                "Option 7 - Print a teacher's subjects by their id number",
                "Option 8 - Delete a person by their id number",
                "Option 9 - Exit program"); // Kalder superclassens (MainMenu) konstruktør
    }

    @Override
    protected void doAction(int option) { // Det er en metode fra Menu, som den overskriver, og det er fra denne metode hele menuen kører.
        switch (option) {
            case 1:
                System.out.println("Option 1 - Add a new student was selected");
                pause();

                System.out.println("Enter student id number:");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (isIdUsed(id)) { // Den tjekker om isIdUsed er true, og hvis den er det
                    System.out.println("ID " + id + " is already in use. Please try again and choose a different ID."); // printer den denne meddelelse, og sender dig til bage til satrt menuen.
                    pause();
                } else { // Hvis den er false, fortsætter den med at lade brugeren indtaste de næste oplysninger.
                    System.out.println("Enter student name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter student email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter student education:");
                    String education = scanner.nextLine();

                    Student newStudent = new Student(id, name, email, education); // Ud fra inputene fra brugeren oprettes der en ny Student.

                    // Input grades for the student
                    boolean addMoreGrades = true; // En boolean til at styre om brugeren vil tilføje flere karakterer, og den starter med at være true.

                    while (addMoreGrades) { // Mens addMoreGrades er true
                        System.out.println("Enter subject for the grade:"); // Indtaster men først et fag
                        String subject = scanner.nextLine();
                        System.out.println("Enter grade for the subject:"); // indtaster man den tilhørende karakter.
                        double grade = scanner.nextDouble();
                        scanner.nextLine();

                        newStudent.addGrade(subject, grade); // Tilføjer karaktererne til studen

                        System.out.println("Do you want to add another grade? (yes/no)"); // Man vælger om man vil indtaste flere karakterer.
                        String response = scanner.nextLine().toLowerCase();

                        if (response.equals("no")) { //Hvis man svarer no
                            addMoreGrades = false; // bliver addMoreGrades sat til false, og while loopet stopper.
                        }

                    }

                    students.add(newStudent); // Tilføjer den nye student til student listen.

                    System.out.println("A new student has been added.\n"); // Printer at en ny student er tilføjet.
                    pause();
                }
                break;
            case 2:
                System.out.println("Option 2 - Add a new teacher was selected");
                pause();

                System.out.println("Enter teachert id number:");
                int idT = scanner.nextInt();
                scanner.nextLine();

                if (isIdUsed(idT)) { // Den tjekker om isIdUsed er true, og hvis den er det
                    System.out.println("ID " + idT + " is already in use. Please try again and choose a different ID."); // printer den denne meddelelse, og sender dig til bage til satrt menuen.
                    pause();
                } else { // Hvis den er false, fortsætter den med at lade brugeren indtaste de næste oplysninger.
                    System.out.println("Enter teacher name:");
                    String nameT = scanner.nextLine();
                    System.out.println("Enter teacher email:");
                    String emailT = scanner.nextLine();
                    System.out.println("Enter teacher initials:");
                    String initials = scanner.nextLine();

                    List<String> subjects = new ArrayList<>(); // Der oprettes en ny subjects liste.

                    Teacher newTeacher = new Teacher(idT, nameT, emailT, initials, subjects); // Ud fra inputene fra brugeren oprettes der en ny teacher.

                    System.out.println("Enter the first subject:"); // Man indtaster det første subject, som hermed også bliver mainSubject, da det får plads 0 i listen.
                    String mainSubject = scanner.nextLine();
                    newTeacher.setMainSubject(mainSubject); // MainSubjectet bliver sat på den nye teacher

                    boolean addMoreSubjects = true; // En boolean til at styre om brugeren vil tilføje flere karakterer subjects.
                    while (addMoreSubjects) { // Mens addMoreSubjects er true
                        System.out.println("Do you want to add another subject? (yes/no)"); // Spørger den om man ønsker at tilføje flere fag.
                        String response = scanner.nextLine().toLowerCase();
                        if (response.equals("yes")) { // Hvis man svarer yes
                            System.out.println("Enter the next subject:"); // Bliver man bedt om at tilføje et nyt fag
                            String nextSubject = scanner.nextLine();
                            subjects.add(nextSubject); // Tilføjer faget til listen
                        } else { // Hvis man ikke svarer yes
                            addMoreSubjects = false; // Bliver addMoreGrades til false.
                        }

                    }

                    teachers.add(newTeacher); // Der bliver tilføjet en ny Teacher.

                    System.out.println("A new teacher has been added.\n"); // Der bliver printet at en ny teacher er blevet tilføjet.
                    pause();
                }
                break;
            case 3:
                System.out.println("Option 3 - Print a list of all students was selected");
                pause();
                System.out.println("ID\t\t\tNAME\t\t\t\t\t\tEMAIL\t\t\t\t\tEDUCATION\t\tAVG.GRADE"); // Den printer en overskrift
                for (Student student : students) { // Den går hele student listen igennem.
                    System.out.println(student); // Den printer hver student
                }
                pause();
                break;
            case 4:
                System.out.println("Option 4 - Print a list of all teachers was selected");
                pause();
                System.out.println("ID\t\t\tNAME\t\t\t\t\t\tEMAIL\t\t\t\t\tINITIALS\t\tMAIN SUBJECT"); // Den printer en overskrift
                for (Teacher teacher : teachers) { // Den går hele teacher listen igennem.
                    System.out.println(teacher); // Den printer hver teacher
                }
                pause();
                break;
            case 5:
                System.out.println("Option 5 - Print a list of all persons was selected");
                pause();
                System.out.println("ID\t\t\tNAME\t\t\t\t\t\tEMAIL\t\t\t\t\tEDUCATION\t\tAVG.GRADE"); // Den printer en overskrift
                for (Student student : students) { // Den går hele student listen igennem.
                    System.out.println(student); // Den printer hver student
                }

                System.out.println(" "); // Den printer et linjeskift

                System.out.println("ID\t\t\tNAME\t\t\t\t\t\tEMAIL\t\t\t\t\tINITIALS\t\tMAIN SUBJECT"); // Den printer en overskrift
                for (Teacher teacher : teachers) { // Den går hele teacher listen igennem.
                    System.out.println(teacher); // Den printer hver teacher
                }
                pause();
                break;
            case 6:
                System.out.println("Option 6 - Print a students gradereport by their id number");
                pause();
                System.out.println("Enter the ID of the student whose grade report you want to print:");
                int idToPrint = scanner.nextInt();
                scanner.nextLine();

                boolean studentFound = false; // En boolean til at se om den student er fundet.

                for (Student student : students) { // Den går den hele student listen igennem.
                    if (student.getId() == idToPrint) { // Hvis den finder en student med det id
                        studentFound = true; // Sætter den studentFound til true
                        System.out.println("Grade Report for Student with ID " + idToPrint + ":\n"); // Den printer en overskrift.

                        List<GradeInfo> gradeReport = student.getGradeReport(); // Den laver en gradereport liste med grades fra getGradreport metoden fra student.
                        for (GradeInfo grade : gradeReport) { // Den går hele gradereport listen i gennem
                            System.out.println("Subject: " + grade.getSubject() + ", Grade: " + grade.getGrade()); // Og printer hvert subject med den tilhørende grade.
                        }
                        break;
                    }
                }

                if (!studentFound) { // Hvis der ikke blev fundet en student med det id
                    System.out.println("Student with ID " + idToPrint + " not found.\n"); // Printer den en besked at der ikke blev funden en student med det id.
                }
                pause();;
                break;
            case 7:
                System.out.println("Option 7 - Print a teacher's subjects was selected");
                pause();
                System.out.println("Enter the ID of the teacher whose subjects you want to print:");
                int teacherIdToPrint = scanner.nextInt();
                scanner.nextLine();

                boolean teacherFound = false; // En boolean til at se om den teacher er fundet.

                for (Teacher teacher : teachers) { // Den går den hele teacher listen igennem.
                    if (teacher.getId() == teacherIdToPrint) { // Hvis den finder en teacher med det id
                        teacherFound = true; // Sætter den teacherFound til true
                        System.out.println("Subjects for Teacher with ID " + teacherIdToPrint + ":"); // Printer en overskrift
                        List<String> subjects2 = teacher.getSubjects(); // Laver en subject liste med fagene fra getSubject() metoden fra Teacher
                        for (String subject : subjects2) { // Den går hele subject listen i gennem
                            System.out.println(subject); // Og printer hvert subject.
                        }
                        break;
                    }
                }

                if (!teacherFound) { // Hvis der ikke blev fundet en teacher med det id
                    System.out.println("Teacher with ID " + teacherIdToPrint + " not found."); // Printer den en besked at der ikke blev funden en teacher med det id.
                }
                pause();
                break;
            case 8:
                System.out.println("Option 8 - Delete a person by ID was selected");
                pause();
                System.out.println("Enter the ID of the person you want to delete:");
                int idToDelete = scanner.nextInt();
                scanner.nextLine();

                boolean personFound = false; // En boolean til at se om personen der ønskes slettet er fundet.
                // Check both students and teachers for the person
                for (Student student : students) { // så går den først hele student listen igennem.
                    if (student.getId() == idToDelete) { // Hvis den finder en student med det id man ønsker at slette
                        students.remove(student); // sletter den den student
                        personFound = true; // og sætter personFound til true
                        System.out.println("Student with ID " + idToDelete + " has been deleted."); // Og printer en besked at den student er blevet slettet.
                        break;
                    }
                }
                if (!personFound) { // Hvis den ikke fandt en med det id i steudent listen går den videre til teacher listen.
                    for (Teacher teacher : teachers) { // så går den hele teacher listen igennem.
                        if (teacher.getId() == idToDelete) { // Hvis den finder en teacher med det id man ønsker at slette
                            teachers.remove(teacher); // sletter den den teacher
                            personFound = true; // og sætter personFound til true
                            System.out.println("Teacher with ID " + idToDelete + " has been deleted."); // Og printer en besked at den techer er blevet slettet.
                            break;
                        }
                    }
                }

                if (!personFound) { // Hvis der stadig ikke blev fundet en person med det id der ønskes slettet
                    System.out.println("No person with ID " + idToDelete + " found."); // Printer den en besked at der ikke blev funden en person med det id.
                }
                pause();
                break;
            case 9: // Option 9 gør at man afslutter programmet.
                System.out.println("Option 9 - Exit program was selected");
                pause();
                System.exit(0); // Exit the program
                break;
            default: // Hvis man indtaster en option der ikke findes får man denne besked, og må prøve igen.
                System.out.println("Invalid option.");
                pause();
                break;
        }
    }

    private boolean isIdUsed(int id) { // En metode der tjekker om id er brugt ved hjælp af en boolan
        for (Person person : students) { // Den går hele Person listen igennem.
            if (person.getId() == id) { // Hvis id'et er det samme som et id der allerede eksistere på listen
                return true; // Så returnerer den true.
            }
        }
        return false; // Ellers returnerer den false.
    }
}
