import java.util.Scanner;
/*
 * Abstract class implementing the basic functionality of a console based
 * menu class. A menu can be created by sub-classing this class and implement
 * the abstract method doAction(option).
 *
 * The constructor of the sub-class must invoke the super-class constructor by
 * the instruction
 *
 *          super(“some header”, “menuoption1", "menuoption2");
 *
 * Note, that this instruction must be the first instruction of the sub-class
 * constructor.
 *
 * @author bhp
 */
public abstract class Menu {
    // value used to exit the menu.
    // the value can be changed by the sub-class constructor.
    protected int EXIT_OPTION = 0;

    // The menu header text
    private String header;

    // The list of menu options texts.
    private String[] menuItems;

    /*
     * Abstract method stating what should be done, when a
     * menu option is selected.
     * The method must be overridden by the sub-class.
     * @param option the menu option that has been selected.
     */
    protected abstract void doAction(int option);

    /*
     * Creates an instance of the class with the given header text and
     * menu options.
     * @param header    The header text of the menu.
     * @param menuItems The list of menu items texts.
     */
    public Menu(String header, String... menuItems) {
        this.header = header;
        this.menuItems = menuItems;
    }

    /*
     * Executes the menu until the EXIT_OPTION has been selected.
     * This is an implementation of the Template Method design pattern.
     */
    public void run() {
        boolean done = false;
        while (!done) {
            showMenu();
            int option = getOption();
            doAction(option);
            if (option == EXIT_OPTION) {
                done = true;
            }
        }
    }
    /*
     * Returns a valid menu-option input from the keyboard.
     * The method continues prompting for an option value, until
     * a valid option has been input.
     * @return A valid menu option.
     */

    // Denne metode bruges til at få en gyldig menuindtastning fra brugeren.
    // Metoden fortsætter, indtil en gyldig menuindtastning er modtaget.
    // Gyldige indtastninger skal være heltal fra 0 til antallet af menu muligheder.
    // Hvis brugeren indtaster en ugyldig indtastning (ikke et heltal eller uden for intervallet), bliver de bedt om at indtaste igen.
    // Når en gyldig menuindtastning er modtaget, returneres den.
    private int getOption() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option < 0 || option > menuItems.length) {
            System.out.print("Enter an option: ");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
            } else {
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return option;
    }

    /*
     * Prints out a console menu
     with a header text and a list
     * of menu options. The menu
     options will be assigned the numbers
     * from 1 to the number of
     options in the menu.
     */

    // Denne metode viser menuen på konsollen ved at udskrive menuens overskrift (header)
    // og en nummereret liste over menuindstillingerne, så brugeren kan vælge en handling.
    // Hver menuindstilling er nummereret og vises med den tilsvarende menuindstillingstekst.
    private void showMenu() {
        System.out.println(header);
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
    }

    /*
     * Waits until the 'enter' key is pressed.
     */
    // En metode der ligger en pause ind, hvor man skal trykke enter for at fortsætte.
    protected void pause() {
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    /*
     * Clears the screen by writing several empty lines.
     */
    // En tom metode der var i skelettet.
    protected void clear() {
        }
    }



