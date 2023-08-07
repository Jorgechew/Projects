import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class easy extends JFrame implements ActionListener {
    private JPanel panel;
    private Timer timer;
    private int x = 0;
    private int direction = 1;

    public easy() {
        setTitle("Quadrados Andando");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(x, 50, 50, 50);
            }
        };

        timer = new Timer(10, this);
        timer.start();

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new easy().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += direction;
        if (x <= 0 || x >= getWidth() - 50) {
            direction *= -1;
        }
        panel.repaint();
    }
}