import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Sorter sorter = new Sorter();

        JFrame frame = new JFrame("Jaime's Factory Machine Monitor");
        // kill all threads when frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new VisualiserGUI(sorter));
//        frame.setResizable(false);
        frame.pack();

        // position the frame in the middle of the screen
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = frame.getSize();

        frame.setLocation((screenDimension.width-frameDimension.width)/2, (screenDimension.height-frameDimension.height)/2);

        frame.setVisible(true);
    }
}
