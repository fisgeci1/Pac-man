package drawing;

import controll.KeyBoardLis;
import controll.PathControll;
import mazeDataStructure.Junction;
import mazeDataStructure.JunctionFactory;
import mazeDataStructure.Maze;
import mazeDataStructure.SearchAlgorithm;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GamePanel extends JPanel {

    private IGhost red;
    private IGhost pink;
    private IPacMan pacMan;
    private PathControll pathControll;

    public GamePanel(HashMap<String, Entity> entityHashMap) {
        pathControll = new PathControll();

        pacMan = (IPacMan) entityHashMap.get("pacman");
        red = (IGhost) entityHashMap.get("red");
        pink = (IGhost) entityHashMap.get("pink");
    }


    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);


        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.scale(5, 5);
        graphics2D.clearRect(0, 0, 800, 600);
        graphics2D.setColor(Color.gray);
        graphics2D.fillRect(0, 0, 800, 800);


        drawWalls(graphics2D);


        pathControll.setPathGhost(red);
        pathControll.setPathGhost(pink);
        pathControll.setPathPacMan(pacMan);

//        red.update();
        pacMan.update();

        if(!(new Rectangle(red.getPositionOfEntity().getX(),red.getPositionOfEntity().getY(),5,5).intersects(new Rectangle(pink.getPositionOfEntity().getX(),pink.getPositionOfEntity().getY(),5,5)))){
//            pink.update();
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        graphics2D.setColor(Color.MAGENTA);
        pink.show(graphics2D);
        graphics2D.setColor(Color.RED);
        red.show(graphics2D);
        graphics2D.setColor(Color.YELLOW);
        pacMan.show(graphics2D);
        repaint();
    }


    private void drawJunctions(Graphics2D graphics2D) {
        graphics2D.setColor(Color.red);
        graphics2D.fillOval(10, 10, 5, 5);
        graphics2D.fillOval(40, 10, 5, 5);
        graphics2D.fillOval(50, 10, 5, 5);
        graphics2D.fillOval(90, 10, 5, 5);
        graphics2D.fillOval(100, 10, 5, 5);
        graphics2D.fillOval(130, 10, 5, 5);
        graphics2D.fillOval(25, 30, 5, 5);
        graphics2D.fillOval(40, 30, 5, 5);
        graphics2D.fillOval(50, 30, 5, 5);
        graphics2D.fillOval(70, 30, 5, 5);
        graphics2D.fillOval(90, 30, 5, 5);
        graphics2D.fillOval(100, 30, 5, 5);
        graphics2D.fillOval(115, 30, 5, 5);
        graphics2D.fillOval(10, 40, 5, 5);
        graphics2D.fillOval(25, 40, 5, 5);
        graphics2D.fillOval(50, 40, 5, 5);
        graphics2D.fillOval(60, 40, 5, 5);
        graphics2D.fillOval(70, 40, 5, 5);
        graphics2D.fillOval(80, 40, 5, 5);
        graphics2D.fillOval(90, 40, 5, 5);
        graphics2D.fillOval(115, 40, 5, 5);
        graphics2D.fillOval(130, 40, 5, 5);
        graphics2D.fillOval(25, 55, 5, 5);
        graphics2D.fillOval(40, 55, 5, 5);
        graphics2D.fillOval(50, 55, 5, 5);
        graphics2D.fillOval(90, 55, 5, 5);
        graphics2D.fillOval(100, 55, 5, 5);
        graphics2D.fillOval(115, 55, 5, 5);
        graphics2D.fillOval(10, 70, 5, 5);
        graphics2D.fillOval(40, 70, 5, 5);
        graphics2D.fillOval(50, 70, 5, 5);
        graphics2D.fillOval(90, 70, 5, 5);
        graphics2D.fillOval(100, 70, 5, 5);
        graphics2D.fillOval(130, 70, 5, 5);

    }

    private void drawWalls(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(5, 5, 135, 5);
        graphics2D.fillRect(135, 5, 5, 75);
        graphics2D.fillRect(5, 5, 5, 75);
        graphics2D.fillRect(5, 75, 135, 5);
        graphics2D.fillRect(45, 60, 5, 15);
        graphics2D.fillRect(95, 60, 5, 15);
        graphics2D.fillRect(55, 60, 35, 10);
        graphics2D.fillRect(55, 50, 35, 5);
        graphics2D.fillRect(55, 35, 5, 15);
        graphics2D.fillRect(55, 35, 15, 5);
        graphics2D.fillRect(85, 35, 5, 15);
        graphics2D.fillRect(75, 35, 15, 5);
        graphics2D.fillRect(55, 15, 35, 15);
        graphics2D.fillRect(20, 15, 5, 25);
        graphics2D.fillRect(15, 15, 10, 25);
        graphics2D.fillRect(20, 15, 20, 15);
        graphics2D.fillRect(15, 45, 10, 25);
        graphics2D.fillRect(20, 60, 20, 10);
        graphics2D.fillRect(30, 45, 20, 10);
        graphics2D.fillRect(30, 35, 20, 5);
        graphics2D.fillRect(95, 35, 20, 5);
        graphics2D.fillRect(95, 45, 20, 10);
        graphics2D.fillRect(105, 15, 25, 13);
        graphics2D.fillRect(122, 15, 8, 25);
        graphics2D.fillRect(122, 45, 8, 25);
        graphics2D.fillRect(105, 60, 22, 10);
        graphics2D.fillRect(45, 5, 5, 23);
        graphics2D.fillRect(95, 5, 5, 23);
    }

}
