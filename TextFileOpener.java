import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextFileOpener extends FileOpener {
    TextFileOpener(File file) {
        super(file);
    }
    public void openFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is text file. Do you want to read in console? (y/n): ");
        String answer = scanner.next();
        if (answer.equals("y")) {
            try(FileReader fileReader = new FileReader(this.file);) {
                BufferedReader reader = new BufferedReader(fileReader);
                String next = reader.readLine();
                while (next != null) {
                    System.out.println(next);
                    next = reader.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException("Error when reading text file");
            }
        }
    }
}
