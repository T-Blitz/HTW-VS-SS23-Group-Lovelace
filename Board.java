import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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

class launchpage {
    public JFrame sc;
    buttonImage sett1 = new buttonImage();

    public launchpage(JFrame scn, int width, int height) {
        scn.add(sett1.buttonImage("image/setting.png", width - 60, 5, 40, 40, "Setting"));
        scn.add(sett1.buttonImage("image/XO.png", width / 2 - 20, height - 55, 40, 40, "Home"));
        scn.add(sett1.buttonImage("image/history.png", 10, height - 55, 40, 40, "history"));
        scn.add(sett1.buttonImage("image/profile.png", width - 50, height - 55, 40, 40, "profile"));
    }

}

public class Board {
    public static void main(String args[]) {

        int width = 390, height = 844;
        JFrame screen = new JFrame();
        GameInterface Inf = new GameInterface(width, height);
        // game play = new game(width,height);
        imageC icon = new imageC();
        screen.add(icon.imageC("image/logo.png", 10, 0, 60, 60));
        launchpage l = new launchpage(screen, width, height);
        // screen.add(play);
        screen.add(Inf);

        screen.setSize(width, height);
        screen.setTitle("Tic tac toe");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);
    }

}