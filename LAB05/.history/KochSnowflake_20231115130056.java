import java.awt.*;
import javax.swing.*;
public class KochSnowflake extends JApplet {
  int initiallevel = 0;
  public void init() {
    String StringLevel = JOptionPane.showInputDialog("Enter the Recursion Depth");
    initiallevel = Integer.parseInt(StringLevel);
  }
  public void paint(Graphics z) {
    DrawKoch(z, initiallevel, 20, 280, 280, 280);
    DrawKoch(z, initiallevel, 280, 280, 150, 20);
    DrawKoch(z, initiallevel, 150, 20, 20, 280);
  }
  private void DrawKoch(Graphics z, int level, int a1, int b1, int a5, int b5) {
    int delX, delY, a2, b2, a3, b3, a4, b4;
    if (lev == 0) {
      z.drawLine(a1, b1, x5, y5);
    } else {
      delX = a5 - a1;
      delY = b5 - b1;
      a2 = a1 + delX / 3;
      b2 = b1 + delY / 3;
      a3 = (int) (0.5 * (a1 + a5) + Math.sqrt(3) * (b1 - b5) / 6);
      b3 = (int) (0.5 * (b1 + b5) + Math.sqrt(3) * (a5 - a1) / 6);
      a4 = a1 + 2 * delX / 3;
      b4 = b1 + 2 * delY / 3;
      DrawKoch(z, level - 1, a1, b1, a2, b2);
      DrawKoch(z, level - 1, a2, b2, a3, b3);
      DrawKoch(z, level - 1, a3, b3, a4, b4);
      DrawKoch(z, level - 1, a4, b4, a5, b5);
    }
  }
}