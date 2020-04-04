package drawing;

import controll.KeyBoardLis;
import model.Entity;
import model.IPacMan;

import javax.swing.*;
import java.util.HashMap;

public class Frame extends JFrame {

    public Frame(int width, int height, HashMap<String, Entity> entities) {
        this.setTitle("Pac-Man");
        setSize(width, height);
        GamePanel panel = new GamePanel(entities);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new KeyBoardLis((IPacMan) entities.get("pacman")));
    }


    public void startGame() {
        this.setVisible(true);
    }
}
