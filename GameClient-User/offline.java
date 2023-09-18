import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class launchpage1 {
    public JFrame sc;
    buttonImage sett1 = new buttonImage();

    public launchpage1(JFrame scn, int width, int height) {
        optionbtn mainbtn = new optionbtn("Computer", 90, 600, 210, 40, "Computer", new Color(253, 18, 18),
                new Color(0, 0, 0), new Color(244, 56, 56), scn);
        optionbtn online = new optionbtn("Human", 90, 680, 210, 40, "Human", new Color(51, 253, 18),
                new Color(0, 0, 0), new Color(244, 56, 56), scn);
        scn.add(sett1.buttonImage("image/setting.png", width - 60, 5, 40, 40, "Setting"));
        scn.add(sett1.buttonImage("image/XO.png", width / 2 - 20, height - 55, 40, 40, "Home"));
        scn.add(sett1.buttonImage("image/history.png", 10, height - 55, 40, 40, "history"));
        scn.add(sett1.buttonImage("image/profile.png", width - 50, height - 55, 40, 40, "profile"));
        scn.add(mainbtn.btnFun());
        scn.add(online.btnFun());
    }

}

public class offline {
    offline() {
        int width = 390, height = 844;
        JFrame screen = new JFrame();
        launchpage1 l = new launchpage1(screen, width, height);
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