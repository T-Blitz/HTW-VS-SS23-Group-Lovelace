import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class game {

    game() {

    }

    public void gameAnimation(Graphics2D gh2) {

        Rectangle2D.Double r11 = new Rectangle2D.Double(100, 100, 10, 20);
        gh2.setColor(Color.GREEN);
        gh2.fill(r11);
    }
}
