import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {

    void writeFile(String filename, String content, Password[] passwords) {
        try (FileWriter myWriter = new FileWriter(filename, true)) {
            myWriter.write(content + Arrays.toString(passwords) + "\n");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing.");
            e.printStackTrace();
        }
    }

    void readFromFile(String filename) {
        File file = new File(filename);

        if(!file.exists()) {
            System.out.println("File does not exist");
        }

        try (Scanner myReader = new Scanner(file)){
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }

    void deleteFile(String filename) {
        File file = new File(filename);

        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
