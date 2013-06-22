import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class ShapesDemo2D extends JApplet{
    final static int maxCharHeight = 15;
    final static int minFontSize = 6;
    
    final static Color bg = Color.white;
    final static Color fg = Color.black;
    final static Color red = Color.red;
    final static Color white = Color.white;

    final static BasicStroke stroke = new BasicStroke(2.0f);
    final static BasicStroke wideStroke = new BasicStroke(8.0f);
    
    final static float dash1[] = {10.0f};
    final static BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f); //???

   Dimension totalSize;
   FontMetrics fontMetrics;

  public void init() {
    //Initialize drawing colors;
    setBackground(bg);
    setForeground(fg);
  }

  FontMetrics pickFont(Graphics2D g2, String longString, int xSpace) {
        boolean fontFits = false;
        Font font = g2.getFont();
        FontMetrics fontMetrics = g2.getFontMetrics();
        int size = font.getSize();
        String name = font.getName();
        int style = font.getStyle();

        while ( !fontFits ) {
            if ( (fontMetrics.getHeight() <= maxCharHeight) && (fontMetrics.stringWidth(longString) <= xSpace) ) {
                fontFits = true;
            }
            else {
                if ( size <= minFontSize ) {
                    fontFits = true;
                }
                else {
                    g2.setFont(font = new Font(name,style,--size));
                    fontMetrics = g2.getFontMetrics();
                }
            }
        }
        return fontMetrics;
    }

  public void paint (Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Dimension d= getSize();
    int gridWidth = d.width/6;
    int gridHeight = d.height/2;
  }
  
  public static void main(String[] s) {
    JFrame f = new JFrame("ShapesDemo2D");
    f.addWindowListener(new WindowAdapter() {public void windowClosing (WindowEvent e) {System.exit(0);}});
    JApplet applet = new ShapesDemo2D();
    f.getContentPane().add("Center",applet);
    applet.init();
    f.pack();
    f.setSize(new Dimension(550,100));
    f.setVisible(true);
  }
}
