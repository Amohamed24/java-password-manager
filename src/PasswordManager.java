import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager {

    private final ArrayList<Password> passwords = new ArrayList<>();

    void listPasswords() {
        System.out.println("Here are the list of passwords: ");

        if (passwords.isEmpty()) {
            System.out.println("There are no saved passwords.");
        } else {
            for (Password password : passwords) {
                System.out.println("-" + password);
            }
        }
    }

    void generatePassword(Scanner scanner) {
        System.out.println("What site is this password for?: ");
        String site = scanner.nextLine();

        System.out.println("What is the password for " + site + "?");
        String sitePassword = scanner.nextLine();

        passwords.add(new Password(site, sitePassword));

        System.out.println("Password for " + site + " | " + sitePassword);
    }


    void testPassword(Scanner scanner) {
        System.out.println("What's your password?: ");
        String testPassword = scanner.nextLine();

        if(passwords.isEmpty()) {
            System.out.println("There are no passwords saved yet.");
        } else {
            for (Password password : passwords) {
                if(password.getSitePassword().equalsIgnoreCase(testPassword)) {
                    System.out.println("You selected: " + testPassword);
                }

                if(testPassword.length() > 8) {
                    System.out.println("This is a safe password!");
                } else if (testPassword.length() == 6) {
                    System.out.println("Not bad, but can a make a little bit longer");
                } else {
                    System.out.println("Buddy, this sucks!!! Way too short.");
                }
            }
        }
    }
}
