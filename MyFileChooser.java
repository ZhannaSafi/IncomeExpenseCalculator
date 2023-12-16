import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MyFileChooser extends JFileChooser {
    @Override
    public int showOpenDialog(Component parent) throws HeadlessException {
        System.out.println("Warning: this is console program, so sometimes dialog will not opened");
        System.out.println("Press enter to continue...");
        new Scanner(System.in).nextLine();
        return super.showOpenDialog(parent);
    }
}
