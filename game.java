import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class game {
    private int width;
    private int height;

    public game(int w, int h) {
        width = w;
        height = h;
    }

    public void gameAnimation(Graphics2D gh2) {
        RoundRectangle2D.Double line = new RoundRectangle2D.Double(153, height / 2 - 125, 6, 250, 10, 10);
        gh2.setColor(new Color(245, 136, 19));
        gh2.fill(line);
        RoundRectangle2D.Double line1 = new RoundRectangle2D.Double(153 + 83, height / 2 - 125, 6, 250, 10, 10);
        gh2.fill(line1);
        RoundRectangle2D.Double line2 = new RoundRectangle2D.Double(width / 2 - 125, 380, 250, 6, 10, 10);
        gh2.fill(line2);
        RoundRectangle2D.Double line3 = new RoundRectangle2D.Double(width / 2 - 125, 380 + 83, 250, 6, 10, 10);
        gh2.fill(line3);
    }
}
