import java.io.File;
import java.util.Scanner;

public class WebFileOpener extends FileOpener {

    WebFileOpener(File file) {
        super(file);
    }
    @Override
    public void openFile() {
        System.out.println("This is html file. Do you want to open it? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equals("y")) {
            super.openFile();
        }
    }
}
