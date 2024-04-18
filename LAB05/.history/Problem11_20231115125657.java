import java.awt.*;
import javax.swing.*;

public class KochSnowflake extends JPanel {
    private int depth;

    public KochSnowflake(int depth) {
        this.depth = depth;
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] x = {200, 100, 300, 200};
        int[] y = {100, 300, 300, 100};
        drawKochSnowflake(g, depth, x, y);
    }

    private void drawKochSnowflake(Graphics g, int depth, int[] x, int[] y) {
        if (depth == 0) {
            g.drawPolygon(x, y, 3);
        } else {
            int[] newX = new int[5];
            int[] newY = new int[5];

            // Calculate intermediate points
            for (int i = 0; i < 3; i++) {
                newX[i] = x[i] + (x[i + 1] - x[i]) / 3;
                newY[i] = y[i] + (y[i + 1] - y[i]) / 3;
            }

            newX[3] = (x[0] + x[2]) / 2 + (int) ((x[1] - x[0] - x[2] + x[1]) * Math.sqrt(3) / 6);
            newY[3] = (y[0] + y[2]) / 2 + (int) ((y[1] - y[0] - y[2] + y[1]) * Math.sqrt(3) / 6);

            newX[4] = x[1] + (x[2] - x[1]) / 3;
            newY[4] = y[1] + (y[2] - y[1]) / 3;

            // Recursively draw the four smaller Koch curves
            drawKochSnowflake(g, depth - 1, new int[]{x[0], newX[0], newX[3], newX[4]}, new int[]{y[0], newY[0], newY[3], newY[4]});
            drawKochSnowflake(g, depth - 1, new int[]{newX[0], x[1], newX[1], newX[3]}, new int[]{newY[0], y[1], newY[1], newY[3]});
            drawKochSnowflake(g, depth - 1, new int[]{newX[1], newX[3], x[2], newX[2]}, new int[]{newY[1], newY[3], y[2], newY[2]});
            drawKochSnowflake(g, depth - 1, new int[]{newX[3], newX[4], newX[2], x[3]}, new int[]{newY[3], newY[4], newY[2], y[3]});
        }
    }

    public static void main(String[] args) {
        int depth = 4; // Change the depth to control the level of detail
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Koch Snowflake");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new KochSnowflake(depth));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
