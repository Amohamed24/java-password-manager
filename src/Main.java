import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args) {
        System.out.println("Welcome to Password Manager!");

        System.out.println("Hi! What's your name?: ");
        String name = scanner.nextLine();

        System.out.println("Hello " + name + "!");

        PasswordManager passwordManager = new PasswordManager();


        while(true) {
            System.out.println("\n**********************************");
            System.out.println("What would you like to do today?: ");
            System.out.println("1) Generate a password");
            System.out.println("2) Test strength of my password");
            System.out.println("3) List all of passwords saved");
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
                case 1 -> passwordManager.generatePassword(scanner);
                case 2 -> passwordManager.testPassword(scanner);
                case 3 -> passwordManager.listPasswords();
                default -> System.out.println("Invalid!");
            }
        }

        scanner.close();
    }
}

