import java.io.File;
import java.util.Scanner;

public class TableFileOpener extends FileOpener {
    TableFileOpener(File file) {
        super(file);
    }

    @Override
    public void openFile() {
        System.out.println("This is csv file. Do you want to open it? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equals("y")) {
            super.openFile();
        }
    }
}
