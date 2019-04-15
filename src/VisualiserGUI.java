import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualiserGUI extends JPanel implements ActionListener {

    private Timer timer;
    private JPanel topMenu;
    private DrawPane drawPane;
    private JButton shuffleButton, sortButton;
    private Sorter sorter;

    public VisualiserGUI(Sorter aSorter) {
        super(new BorderLayout());

        this.sorter = aSorter;

        setPreferredSize(new Dimension(700, 600));

        this.drawPane = new DrawPane(sorter.getNumbers());
        this.add(drawPane, BorderLayout.CENTER);

        // Radio buttons
        this.topMenu = new JPanel();
        topMenu.setBackground(new Color(220, 220, 220));

        this.shuffleButton = new JButton("Shuffle");
        this.shuffleButton.addActionListener(this);
        this.shuffleButton.setBackground(null);
        this.topMenu.add(this.shuffleButton);

        this.sortButton = new JButton("Sort");
        this.sortButton.addActionListener(this);
        this.sortButton.setBackground(null);
        this.topMenu.add(this.sortButton);

        this.add(topMenu, BorderLayout.NORTH);

        // Timer to update GUI
        this.timer = new Timer(10, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == shuffleButton) {
            sorter.shuffle();
        } else if (source == sortButton) {
            sorter.sort();
        }
        drawPane.repaint();
    }
}
