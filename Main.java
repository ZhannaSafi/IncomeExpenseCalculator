import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Main extends UserInput {
    public static void main(String[] args) {

        UserInput userInput = new UserInput();
        System.out.println("Доход: ");
        userInput.getInputIncome();
        System.out.println("Расход: ");
        userInput.getInputExpense();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        scanner.nextLine();
        JFileChooser fileChooser = new MyFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        System.out.println(file.getName());

        String[] nameParts = file.getName().split("\\.");
        String ext = nameParts[nameParts.length-1];

        FileOpener opener; // базовый класс
        if (ext.equals("txt")) {
            opener = new TextFileOpener(file);
        } else if (ext.equals("csv")) {
            opener = new TableFileOpener(file);
        } else if (ext.equals("html")) {
            opener = new WebFileOpener(file);
        } else {
            opener = new FileOpener(file);
        }
        executeFile(opener);
    }
    private static void executeFile(FileOpener opener) {
        opener.printFileInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to open file? (y/n): ");
        String answer = scanner.next();
        if (answer.equals("y")) {
            opener.openFile();
        } else {
            System.out.println("Program will terminate");
        }
    }
}
