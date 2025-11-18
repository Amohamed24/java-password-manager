import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager {

    private final ArrayList<Password> passwords = new ArrayList<>();

    void listPasswords() {
        if (passwords.isEmpty()) {
            System.out.println("There are no saved passwords.");
        } else {
            System.out.println("\nHere is the list of passwords: ");
            for (Password password : passwords) {
                System.out.println("-" + password);
            }
        }
    }

    public Password[] getAllPasswords() {
        return passwords.toArray(new Password[0]);
    }

    void generatePassword(Scanner scanner, User user) {
        System.out.println("What site is this password for?: ");
        String site = scanner.nextLine();

        System.out.println("What is the password for " + site + "?");
        String sitePassword = scanner.nextLine();

        // DONE: check if site is unique
        for (Password password : passwords) {
            if (password.getSite().equalsIgnoreCase(site)) {
                System.out.println("Invalid! This site already exists");
                return;
            }
        }

        // DONE: password can't be their name or site
        if (user.getName().equalsIgnoreCase(sitePassword)) {
            System.out.println("Invalid! Password CANNOT equal name!");
        } else if (site.equalsIgnoreCase(sitePassword)) {
            System.out.println("Invalid! Password CANNOT equal site!");
        } else {
            passwords.add(new Password(site, sitePassword));
            System.out.println("Password for: '" + site + "' | " + sitePassword);
        }


        // TO DO: add way for user to have random password made for them
        // a) ask for what site
        // b) show randomPassword
        // c) ask if they want this as password
        // d) loop;
        // if no = show option if they want to make their own or another randomPassword
        // if yes = add that password to site, and show their listPasswords updated
    }

    void testPassword(Scanner scanner) {
        listPasswords();

        // DONE: added check to make sure password exists,
        // DONE: added check to verify if correct password
        if (passwords.isEmpty()) return;

        System.out.println("Which site would you like to test?: ");
        String testSite = scanner.nextLine();

        Password match = null;

        for (Password password : passwords) {
            if (password.getSite().equalsIgnoreCase(testSite)) {
                match = password;
                break;
            }
        }

        if (match == null) {
            System.out.println("This site does not exist.");
            return;
        }

        System.out.println("Testing password for: " + testSite);

        String pw = match.getSitePassword();

        if (pw.length() > 8) {
            System.out.println("This is a safe password!");
        } else if (pw.length() == 6) {
            System.out.println("Not bad, but could be longer.");
        } else {
            System.out.println("Buddy… this password sucks 💀.");
        }
    }

    void deletePassword(Scanner scanner) {
        // DONE: check if there are any passwords in list
        if (passwords.isEmpty()) {
            System.out.println("There are no passwords!");
            return;
        }

        listPasswords();

        System.out.println("\nWhich site is this password from?: ");
        String deleteSite = scanner.nextLine();

        //DONE: check if password matches other, so if deleting, only deleting from site
        boolean found = false;
        for (int i = 0; i < passwords.size(); i++){
            if (passwords.get(i).getSite().equalsIgnoreCase(deleteSite)) {
                System.out.println("Deleting site: " + passwords.get(i).getSite() +
                        " and password: " + passwords.get(i).getSitePassword());
                passwords.remove(i);
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Site is not found. Nothing was deleted");
        }
    }
}
