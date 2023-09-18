import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class Reference {
    public static Font mansalva;

    public static HashMap<Integer, Boolean> gamegrid = new HashMap<Integer, Boolean>();
}

class infobtngame {
    infobtngame(int count, int x, int y, int d, JFrame src) {

    }
}

class gameanimation1 extends JFrame implements ActionListener {
    private static Object obj = new Object();
    ArrayList<Object> arr = new ArrayList<Object>();
    ArrayList<ArrayList<Integer>> check = new ArrayList<>();
    ArrayList<Integer> a1 = new ArrayList<>();

    int count = 0;
    Boolean flag = true;
    JFrame sc;
    JLabel res;

    protected gameanimation1(JFrame scr) {

        sc = scr;
        a1.add(0);
        a1.add(3);
        a1.add(6);
        check.add((ArrayList) a1.clone());
        a1.clear();
        a1.add(1);
        a1.add(4);
        a1.add(7);
        check.add((ArrayList) a1.clone());
        a1.clear();
        a1.add(2);
        a1.add(5);
        a1.add(8);
        check.add((ArrayList) a1.clone());
        a1.clear();
        a1.add(0);
        a1.add(1);
        a1.add(2);
        check.add((ArrayList) a1.clone());
        a1.clear();
        a1.add(3);
        a1.add(4);
        a1.add(5);
        check.add((ArrayList) a1.clone());
        a1.clear();
        a1.add(6);
        a1.add(7);
        a1.add(8);
        check.add((ArrayList) a1.clone());
        a1.clear();
        a1.add(0);
        a1.add(4);
        a1.add(8);
        check.add((ArrayList) a1.clone());
        a1.clear();
        a1.add(2);
        a1.add(4);
        a1.add(6);
        check.add((ArrayList) a1.clone());
        a1.clear();
        HashMap<Integer, Integer[]> prices = new HashMap<Integer, Integer[]>();
        int[][] animation = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 } };

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

            for (int i = 0; i < animation[j].length; i++) {

                JButton b = new JButton();
                arr.add(b);
                b.setFont(new Font("Dialog", Font.BOLD, 70));
                b.setOpaque(false);
                b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                b.setContentAreaFilled(false);
                b.setBorderPainted(false);
                b.setFocusPainted(false);
                b.setBackground(new Color(96, 96, 255));
                b.setBounds(prices.get(animation[j][i])[0], prices.get(animation[j][i])[1], 100, 70);
                b.addActionListener(this);
                scr.add(b);

            }
        }
        res = new JLabel("");
        res.setFont(Reference.mansalva.deriveFont(40f));
        res.setBounds(40, 650, 300, 40);
        res.setHorizontalAlignment(SwingConstants.CENTER);
        scr.add(res);
    }

    public void winner() {

        System.out.println(check.size());
        System.out.println(check.get(0).size());

        for (int i = 0; i < check.size(); i++) {
            String str = "";
            int r = 1;
            String f = ((JButton) arr.get(check.get(i).get(0))).getText();
            String d = ((JButton) arr.get(check.get(i).get(1))).getText();
            String g = ((JButton) arr.get(check.get(i).get(2))).getText();

            if (f.equals(d) & f.equals(g) & !f.equals("")) {
                flag = false;
                System.out.println("Winner " + f);
                res.setText(f + " is the Winner");
                break;
            }
        }
        if (flag & count == 9) {
            System.out.println("Draw Match");
            res.setText("Draw Match");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < arr.size(); i++) {
            JButton f = ((JButton) arr.get(i));
            JButton d = ((JButton) e.getSource());
            if (f.getX() == d.getX() & f.getY() == d.getY() & f.getText().equals("") & flag) {
                f.setForeground(new Color(149, 223, 255));
                if (count % 2 == 1) {
                    f.setForeground(new Color(255, 255, 255));
                }
                f.setText((count % 2 == 0) ? "X" : "O");
                count++;
                winner();
            }
        }

        // logo.setText("Roseindia.net");
    }
}

class launchpage2 {
    public JFrame sc;
    buttonImage sett1 = new buttonImage();
    // optionbtn mainbtn = new optionbtn("Computer", 90, 600, 210, 40, "Computer",
    // new Color(253, 18, 18),
    // new Color(0, 0, 0), new Color(244, 56, 56));
    // optionbtn online = new optionbtn("Human", 90, 680, 210, 40, "Human", new
    // Color(51, 253, 18),
    // new Color(0, 0, 0), new Color(244, 56, 56));

    public launchpage2(JFrame scn, int width, int height) {
        scn.add(sett1.buttonImage("image/setting.png", width - 60, 5, 40, 40, "Setting"));
        scn.add(sett1.buttonImage("image/XO.png", width / 2 - 20, height - 55, 40, 40, "Home"));
        scn.add(sett1.buttonImage("image/history.png", 10, height - 55, 40, 40, "history"));
        scn.add(sett1.buttonImage("image/profile.png", width - 50, height - 55, 40, 40, "profile"));
        // scn.add(mainbtn.btnFun());
        // scn.add(online.btnFun());
    }

}

public class human {
    human() {
        try {
            Reference.mansalva = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/Mansalva-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/Mansalva-Regular.ttf")));
        } catch (IOException e) {
            System.out.println(e);
        } catch (FontFormatException e) {
            System.out.println(e);
        }
        int width = 390, height = 844;
        JFrame screen = new JFrame();
        launchpage2 l = new launchpage2(screen, width, height);
        imageC icon = new imageC();
        screen.add(icon.imageC("image/logo.png", 10, 0, 60, 60));
        gameanimation1 l1 = new gameanimation1(screen);
        GameInterface Inf = new GameInterface(width, height);

        screen.add(Inf);
        screen.setSize(width, height);
        screen.setTitle("Tic tac toe");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);

    }

}