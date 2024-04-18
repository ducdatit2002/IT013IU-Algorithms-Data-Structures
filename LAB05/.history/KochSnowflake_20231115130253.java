
import java.awt.*;
import javax.swing.*;

public class KochSnowflake extends JPanel {
    private int order;

    public KochSnowflake(int order) {
        this.order = order;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Point p1 = new Point(width / 2, 0);
        Point p2 = new Point(0, height - 1);
        Point p3 = new Point(width - 1, height - 1);
        drawKochSnowflake(g, p1, p2, order);
        drawKochSnowflake(g, p2, p3, order);
        drawKochSnowflake(g, p3, p1, order);
    }

    private void drawKochSnowflake(Graphics g, Point p1, Point p2, int order) {
        if (order == 0) {
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        } else {
            int dx = p2.x - p1.x;
            int dy = p2.y - p1.y;
            Point pA = new Point(p1.x + dx / 3, p1.y + dy / 3);
            Point pC = new Point(p2.x - dx / 3, p2.y - dy / 3);
            double angle = Math.toRadians(60);
            int x = (int) (pC.x - pA.x) * 2 / 3;
            int y = (int) (pC.y - pA.y) * 2 / 3;
            int dx2 = (int) (x * Math.cos(angle) - y * Math.sin(angle));
            int dy2 = (int) (x * Math.sin(angle) + y * Math.cos(angle));
            Point pB = new Point(pA.x + dx2, pA.y + dy2);
            drawKochSnowflake(g, p1, pA, order - 1);
            drawKochSnowflake(g, pA, pB, order - 1);
            drawKochSnowflake(g, pB, pC, order - 1);
            drawKochSnowflake(g, pC, p2, order - 1);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Koch Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        KochSnowflake snowflake = new KochSnowflake(4);
        frame.add(snowflake);
        frame.setVisible(true);
    }
}
