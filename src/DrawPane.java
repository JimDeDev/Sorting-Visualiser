import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPane extends JPanel {

    private static final Integer SCALE_FACTOR = 1;
    private int[] numbers;

    public DrawPane(int[] numbers) {
        this.numbers = numbers;

        JLabel graphTitle = new JLabel("Graph of Machine Temperatures in C");

        this.add(graphTitle);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int barWidth = (this.getWidth() - 5) / numbers.length;

        int bottomOffset = this.getHeight() - 20;

        g.setColor(Color.BLUE);

        int xOffset = 5;
        for(Integer integer : numbers) {

            g.fillRect(xOffset, (bottomOffset - (integer * SCALE_FACTOR)), barWidth, integer * SCALE_FACTOR);
            xOffset += barWidth;
        }

    }
}

