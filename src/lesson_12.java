import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class lesson_12 {
    public static void main() {
        SwingUtilities.invokeLater(() -> {
            BouncingAnimation animation = new BouncingAnimation();
            animation.setVisible(true);
        });
    }
}

class BouncingAnimation extends JFrame {

    private int xPosition1 = 50;
    private int yPosition1 = 50;
    private int xSpeed1 = 2;
    private int ySpeed1 = 3;
    private final int RECTANGLE_WIDTH = 50;
    private final int RECTANGLE_HEIGHT = 50;
    private final int DELAY = 10;
    private final Random random = new Random();
    private Color targetColor = generateRandomColor();
    private Color currentColor = generateRandomColor();
    private int steps = 100;
    private int currentStep = 0;

    public BouncingAnimation() {
        setTitle("Анімація відбиття");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        Timer timer = new Timer(DELAY, new MyTimerActionListener());
        timer.start();

        getContentPane().setLayout(null);

        MyPanel1 panel1 = new MyPanel1();
        panel1.setBounds(0, 0, 500, 500);
        getContentPane().add(panel1);
    }

    private Color generateRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private Color interpolateColor(Color from, Color to, int steps, int currentStep) {
        int redStep = (to.getRed() - from.getRed()) / steps;
        int greenStep = (to.getGreen() - from.getGreen()) / steps;
        int blueStep = (to.getBlue() - from.getBlue()) / steps;

        int red = from.getRed() + redStep * currentStep;
        int green = from.getGreen() + greenStep * currentStep;
        int blue = from.getBlue() + blueStep * currentStep;

        return new Color(red, green, blue);
    }

    private class MyPanel1 extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            currentColor = interpolateColor(currentColor, targetColor, steps, currentStep);
            g.setColor(currentColor);
            g.fillRect(xPosition1, yPosition1, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        }
    }

    private class MyTimerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            xPosition1 += xSpeed1;
            yPosition1 += ySpeed1;

            if (xPosition1 <= 0 || xPosition1 >= getWidth() - 65) {
                xSpeed1 = -xSpeed1;
            }
            if (yPosition1 <= 0 || yPosition1 >= getHeight() - 80) {
                ySpeed1 = -ySpeed1;
            }

            currentStep = (currentStep + 1) % steps;
            if (currentStep == 0) {
                targetColor = generateRandomColor();
            }

            getContentPane().repaint();
        }
    }
}