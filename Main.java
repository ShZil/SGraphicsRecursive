import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class Main extends Canvas {
  int sizeX = 1024;
  int sizeY = 1024;

  public void paint(Graphics gr) {
    SGraphics g = new SGraphics(gr, sizeX, sizeY);
    g.finishFrame(gr);
  }
  public static void main(String[] args) {
    // General Java Code for every Rendering Project.
    Main m = new Main();
    JFrame f = new JFrame();

    f.add(m);
    f.setSize(1060, 1060);
    f.setPreferredSize(new Dimension(m.sizeX, m.sizeY));
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);

    // Mouse listener
    m.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        m.repaint();
      }
    });

    // Resize listener
    m.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        System.out.println("Frame Resized to " + e.getComponent().getSize());
      }
    });
  }
}
