import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// pls for the love of god can we move lines 13 to 27 into the library?
// and use a seperate class for the main method
// Yeah... but this is a lot of work and would likely require lots of debugging. "If it ain't broke, don't fix it"

class MainExample extends Canvas {
  // The size of the canvas, or panel. In pixels.
  int sizeX = 500;
  int sizeY = 500;

  public void paint(Graphics gr) {
    // Create SmartGraphics instance.
    SGraphics g = new SGraphics(gr, sizeX, sizeY);

    // All the drawing attempts and syntax review here:
    g.drawRect(new Rect(100, 100), Const.WHITE);

    // What SHOULD Happen (java.awt.Graphics code):

    // gr.setColor(new Color(0, 0, 0));
    // gr.fillRect(0, 0, 100, 100);

    g.finishFrame(gr);
  }
  public static void main(String[] args) {
    // General Java Code for every Rendering Project.
    MainExample m = new MainExample();
    JFrame f = new JFrame();

    f.add(m);
    f.setSize(m.sizeX, m.sizeY);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Lets you write more commands in the cmd after the program is closed. int predefined value.
    f.setVisible(true);

    // Mouse listener. Copied from my other projects.
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
