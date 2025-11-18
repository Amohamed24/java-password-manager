import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args) {
        System.out.println("Welcome to Password Manager!");

        PasswordManager passwordManager = new PasswordManager();

        System.out.println("Hi! What's your name?: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");

        User user = new User(name);

        FileHandler file = new FileHandler();
        final String filename = "passwords.txt";


        while(true) {
            System.out.println("\n**********************************");
            System.out.println("What would you like to do today?: ");
            System.out.println("1) Generate a password");
            System.out.println("2) Test strength of my password");
            System.out.println("3) List all passwords saved");
            System.out.println("4) Remove a password");
            System.out.println("5) Write passwords to file");
            System.out.println("6) Read passwords from file");
            System.out.println("7) Delete the file");
            System.out.println("(type q) to quit");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thanks for playing " + name);
                break;
            }

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid! Please enter 1 or 2");
                continue;
            }

            switch(choice) {
                case 1 -> passwordManager.generatePassword(scanner, user);
                case 2 -> passwordManager.testPassword(scanner);
                case 3 -> passwordManager.listPasswords();
                case 4 -> passwordManager.deletePassword(scanner);
                case 5 -> {
                    String content = "Saved passwords:";
                    file.writeFile(filename, content, passwordManager.getAllPasswords());
                }
                case 6 -> file.readFromFile(filename);
                case 7 -> file.deleteFile(filename);
                default -> System.out.println("Invalid!");
            }
        }

        scanner.close();
    }
}

