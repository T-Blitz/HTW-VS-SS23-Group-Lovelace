import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.geom.*;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.*;

public class GameInterface extends JComponent {
    private int width;
    private int height;
    Font mansalva;
    private game gameAni;

    public GameInterface(int w, int h) {
        width = w;
        height = h;
        gameAni = new game(width, height);
    }

    protected void paintComponent(Graphics g) {

        Graphics2D gh2 = (Graphics2D) g;
        try {
            mansalva = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/Mansalva-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/Mansalva-Regular.ttf")));
        } catch (IOException e) {
            System.out.println(e);
        } catch (FontFormatException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
        RenderingHints renSm = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gh2.setRenderingHints(renSm);
        Rectangle2D.Double r = new Rectangle2D.Double(0, 0, width, height);
        gh2.setColor(new Color(96, 96, 96));
        gh2.fill(r);
        Rectangle2D.Double top = new Rectangle2D.Double(0, 0, 390, 61);
        gh2.setColor(new Color(245, 136, 19));
        gh2.fill(top);
        Rectangle2D.Double bottom = new Rectangle2D.Double(0, height - 61, 390, 61);
        gh2.fill(bottom);
        gameAni.gameAnimation(gh2);
        gh2.setFont(mansalva.deriveFont(65f));

        TextLayout t1 = new TextLayout("Tic Tac", mansalva.deriveFont(65f), gh2.getFontRenderContext());
        TextLayout t2 = new TextLayout("  Toe", mansalva.deriveFont(65f), gh2.getFontRenderContext());
        Shape shape = t1.getOutline(null);
        Shape shape1 = t2.getOutline(null);
        gh2.translate(80, 156);
        gh2.setColor(new Color(234, 231, 231));
        gh2.fill(shape);
        gh2.setColor(new Color(12, 12, 12));
        gh2.draw(shape);
        gh2.translate(14, 65);
        gh2.setColor(new Color(234, 231, 231));
        gh2.fill(shape1);
        gh2.setColor(new Color(12, 12, 12));
        gh2.draw(shape1);

        // gh2.drawString("Tic Tac",80,78*2);
        // gh2.drawString(" Toe",90,78*2+65);

    }
}
