import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class KochSnowflake extends JPanel {
    private List<Line2D> lines = new ArrayList<>();

    public KochSnowflake(int order) {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 650));
        // Start with an equilateral triangle
        Point p1 = new Point(400, 100);
        Point p2 = new Point(100, 650);
        Point p3 = new Point(700, 650);
        // Recursively create the snowflake
        generateSnowflake(p1, p2, order);
        generateSnowflake(p2, p3, order);
        generateSnowflake(p3, p1, order);
    }

    private void generateSnowflake(Point p1, Point p2, int order) {
        if (order == 0) {
            // Draw the line segment
            lines.add(new Line2D.Double(p1.x, p1.y, p2.x, p2.y));
        } else {
            int dx = p2.x - p1.x;
            int dy = p2.y - p1.y;
            Point p3 = new Point(p1.x + dx / 3, p1.y + dy / 3);
            Point p4 = new Point(p1.x + dx * 2 / 3, p1.y + dy * 2 / 3);
            Point p5 = new Point((int) (p3.x + Math.cos(Math.toRadians(60)) * (p4.x - p3.x) - Math.sin(Math.toRadians(60)) * (p4.y - p3.y)),
                                 (int) (p3.y + Math.sin(Math.toRadians(60)) * (p4.x - p3.x) + Math.cos(Math.toRadians(60)) * (p4.y - p3.y)));
            // Recurse on the four new lines
            generateSnowflake(p1, p3, order - 1);
            generateSnowflake(p3, p5, order - 1);
            generateSnowflake(p5, p4, order - 1);
            generateSnowflake(p4, p2, order - 1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Line2D line : lines) {
            g2d.draw(line);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Koch Snowflake");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new KochSnowflake(4));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
