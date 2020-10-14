import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Main extends Canvas {
  int sizeX = 512;
  int sizeY = 512;

  public void paint(Graphics gr) {
    SGraphics g = new SGraphics(gr, sizeX, sizeY);

    // All the drawing attempts and syntax review here:
    // g.drawRect(new Rect(100, 100), Const.WHITE);
    gr.setColor(new Color(255, 0, 0));
    gr.fillRect(10, 10, 20, 20);

    g.finishFrame(gr);
  }
  public static void main(String[] args) {
    // General Java Code for every Rendering Project.
    MainExample m = new MainExample();
    JFrame f = new JFrame();

    f.add(m);
    f.setSize(m.sizeX, m.sizeY);
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
  }
}
