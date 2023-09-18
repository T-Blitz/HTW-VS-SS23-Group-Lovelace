import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class imageC extends JLabel {
    public JLabel logo;
    private String loc;
    private int locX;
    private int locY;
    private int Jwidth;
    private int Jheight;

    public JLabel imageC(String Loc, int x, int y, int width, int height) {
        loc = Loc;
        locX = x;
        locY = y;
        Jwidth = width;
        Jheight = height;
        System.out.println("Hi");
        JLabel logo = new JLabel();
        logo.setBounds(locX, locY, Jwidth, Jheight);
        Image getSett = new ImageIcon(loc).getImage();
        logo.setIcon(new ImageIcon(getSett.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        return logo;
    }
}

class buttonImage extends JButton implements ActionListener {
    private JButton logo;
    private String loc;
    private String id;
    private int locX;
    private int locY;
    private int Jwidth;
    private int Jheight;

    public JButton buttonImage(String Loc, int x, int y, int width, int height, String name) {
        loc = Loc;
        locX = x;
        locY = y;
        Jwidth = width;
        Jheight = height;
        id = name;
        JButton logo = new JButton(new ImageIcon());
        logo.addActionListener(this);
        logo.setToolTipText(id);
        logo.setFocusable(false);
        logo.setOpaque(false);
        logo.setContentAreaFilled(false);
        logo.setBorderPainted(false);
        logo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logo.setBounds(locX, locY, Jwidth + 10, Jheight + 10);
        Image getSett = new ImageIcon(loc).getImage();
        logo.setIcon(new ImageIcon(getSett.getScaledInstance(Jwidth, Jheight, Image.SCALE_SMOOTH)));
        return logo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(id);
        if (id.equals("Setting")) {
            sample sm = new sample();
        } else if (id.equals("Home")) {
            tictactoe nw = new tictactoe();
            System.out.println("not working");
        }
    }
}

class RoundedBorder implements Border {

    private int radius;
    private Color bgc;

    RoundedBorder(int radius, Color bg) {
        this.radius = radius;
        this.bgc = bg;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return false;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

        g.setColor(bgc);
        // g.fillRoundRect(x, y, width - 1, height - 1, radius, radius);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        // g.drawString("hello", x, y);
    }
}

class optionbtn extends JButton implements ActionListener {
    private String loc;
    private String id;
    private int locX;
    private int locY;
    private int Jwidth;
    private int Jheight;
    private Color btncolor;
    private Color txtcolor;
    private Color pressedBackgroundColor;
    private Color hoverBackgroundColor;
    JButton logo;
    Font mansalva;
    JFrame sc;

    public optionbtn(String Loc, int x, int y, int width, int height, String name, Color design, Color design1,
            Color design2, JFrame scn) {
        loc = Loc;
        locX = x;
        locY = y;
        Jwidth = width;
        Jheight = height;
        id = name;
        btncolor = design;
        txtcolor = design1;
        pressedBackgroundColor = design2;
        hoverBackgroundColor = design2;
        sc = scn;
        try {
            mansalva = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/Mansalva-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/Mansalva-Regular.ttf")));
        } catch (IOException e) {
            System.out.println(e);
        } catch (FontFormatException e) {
            System.out.println(e);
        }
    }

    public JButton btnFun() {

        logo = new JButton(loc);
        // logo.addActionListener(this);
        logo.setToolTipText(id);
        logo.setFocusable(false);
        logo.setBackground(btncolor);
        logo.setForeground(txtcolor);
        logo.setBorder(new RoundedBorder(20, btncolor));
        logo.setOpaque(true);
        logo.setContentAreaFilled(true);
        // logo.setBorderPainted(false);
        logo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logo.setBounds(locX, locY, Jwidth + 10, Jheight + 10);
        logo.setFont(mansalva.deriveFont(25f));
        logo.addActionListener(this);
        return logo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (id.equals("Offline")) {
            sc.dispose();
            offline v = new offline();
        } else if (id.equals("Human")) {
            sc.dispose();
            human v = new human();
        }
        // logo.setText("Roseindia.net");
    }

}

class launchpage {
    public JFrame sc;
    buttonImage sett1 = new buttonImage();

    public launchpage(JFrame scn, int width, int height) {
        optionbtn mainbtn = new optionbtn("Offline", 90, 600, 210, 40, "Offline", new Color(253, 18, 18),
                new Color(0, 0, 0), new Color(244, 56, 56), scn);
        optionbtn online = new optionbtn("Online", 90, 680, 210, 40, "Online", new Color(51, 253, 18),
                new Color(0, 0, 0), new Color(244, 56, 56), scn);
        scn.add(sett1.buttonImage("image/setting.png", width - 60, 5, 40, 40, "Setting"));
        scn.add(sett1.buttonImage("image/XO.png", width / 2 - 20, height - 55, 40, 40, "Home"));
        scn.add(sett1.buttonImage("image/history.png", 10, height - 55, 40, 40, "history"));
        scn.add(sett1.buttonImage("image/profile.png", width - 50, height - 55, 40, 40, "profile"));
        scn.add(mainbtn.btnFun());
        scn.add(online.btnFun());
    }

}

class gameanimation {
    private static Object obj = new Object();

    public gameanimation(JFrame scr) {
        HashMap<Integer, Integer[]> prices = new HashMap<Integer, Integer[]>();
        int[][] animation = { { 1, 9, 7, 4, 3, 2, 5 }, { 9, 1, 8, 7, 6, 4 }, { 1, 5, 7, 4, 6, 3, 8, 9, 2 } };

        ArrayList<Object> arr = new ArrayList<Object>();
        prices.put(1, new Integer[] { 65, 300 });
        prices.put(2, new Integer[] { 145, 300 });
        prices.put(3, new Integer[] { 225, 300 });
        prices.put(4, new Integer[] { 65, 390 });
        prices.put(5, new Integer[] { 145, 390 });
        prices.put(6, new Integer[] { 225, 390 });
        prices.put(7, new Integer[] { 65, 470 });
        prices.put(8, new Integer[] { 145, 470 });
        prices.put(9, new Integer[] { 225, 470 });
        for (int j = 0; j < 1; j++) {
            int count = 0;
            for (int i = 0; i < animation[j].length; i++) {

                JButton b = new JButton((count % 2 == 0) ? "X" : "O");
                arr.add(b);
                b.setFont(new Font("Dialog", Font.BOLD, 70));
                b.setOpaque(false);
                b.setForeground(new Color(149, 223, 255));
                b.setContentAreaFilled(false);
                b.setBorderPainted(false);
                b.setFocusPainted(false);
                b.setBackground(new Color(96, 96, 255));
                if (count % 2 == 1) {
                    b.setForeground(new Color(255, 255, 255));
                }
                b.setBounds(prices.get(animation[j][i])[0], prices.get(animation[j][i])[1], 100, 70);
                scr.add(b);
                count++;
            }
            // scr.getContentPane().remove(((JComponent) arr.get(0)));
        }

    }
}

public class Board {
    public static void main(String args[]) {
        int width = 390, height = 844;
        JFrame screen = new JFrame();
        launchpage l = new launchpage(screen, width, height);
        imageC icon = new imageC();
        screen.add(icon.imageC("image/logo.png", 10, 0, 60, 60));
        gameanimation l1 = new gameanimation(screen);
        GameInterface Inf = new GameInterface(width, height);
        screen.add(Inf);
        screen.setSize(width, height);
        screen.setTitle("Tic tac toe");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);

    }

}
