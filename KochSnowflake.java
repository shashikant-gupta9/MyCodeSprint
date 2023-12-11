import javax.swing.*;
import java.awt.*;

public class KochSnowflake extends JFrame {
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 600;
    private final int LEVEL = 5;

    public KochSnowflake() {
        setTitle("Koch Snowflake");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        KochPanel kochPanel = new KochPanel(LEVEL);
        add(kochPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KochSnowflake snowflake = new KochSnowflake();
            snowflake.setVisible(true);
        });
    }
}

class KochPanel extends JPanel {
    private int level;

    public KochPanel(int level) {
        this.level = level;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSnowflake(g, level, 50, 450, 750, 450);
        drawSnowflake(g, level, 750, 450, 400, 50);
        drawSnowflake(g, level, 400, 50, 50, 450);
    }

    private void drawSnowflake(Graphics g, int lev, int x1, int y1, int x5, int y5) {
        if (lev == 0) {
            g.drawLine(x1, y1, x5, y5);
        } else {
            int deltaX = x5 - x1;
            int deltaY = y5 - y1;

            int x2 = x1 + deltaX / 3;
            int y2 = y1 + deltaY / 3;

            int x3 = (int) (0.5 * (x1 + x5) + Math.sqrt(3.0) * (y1 - y5) / 6);
            int y3 = (int) (0.5 * (y1 + y5) + Math.sqrt(3.0) * (x5 - x1) / 6);

            int x4 = x1 + 2 * deltaX / 3;
            int y4 = y1 + 2 * deltaY / 3;

            drawSnowflake(g, lev - 1, x1, y1, x2, y2);
            drawSnowflake(g, lev - 1, x2, y2, x3, y3);
            drawSnowflake(g, lev - 1, x3, y3, x4, y4);
            drawSnowflake(g, lev - 1, x4, y4, x5, y5);
        }
    }
}

