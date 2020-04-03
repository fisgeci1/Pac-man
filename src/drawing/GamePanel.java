package drawing;

import controll.KeyBoardLis;
import controll.PathControll;
import mazeDataStructure.JunctionFactory;
import mazeDataStructure.Maze;
import mazeDataStructure.SearchAlgorithm;
import model.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private IGhost red;
    private IGhost pink;
    private IPacMan pacMan;
    private Maze maze;
    private PathControll pathControll;


    public GamePanel() {

        JunctionFactory junctionFac = new JunctionFactory();
        pathControll = new PathControll();
        this.maze = junctionFac.getMaze();
        SearchAlgorithm search = new SearchAlgorithm(maze);
        pacMan = new PacMan(new Position(100, 70, maze.getJunctionHashMap().get("n27"), maze.getJunctionHashMap().get("n28")));
        Position pos = new Position(25, 55, maze.getJunctionHashMap().get("n10"), maze.getJunctionHashMap().get("n10"));
        red = new Ghost(pos, GhostType.RED, search, pacMan);
        Position pos2 = new Position(10, 70, maze.getJunctionHashMap().get("n7"), maze.getJunctionHashMap().get("n7"));
        pink = new Ghost(pos2, GhostType.PINK, search, pacMan);


        JFrame frame = new JFrame();
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(1200, 100);
        frame.setSize(800, 600);
        frame.addKeyListener(new KeyBoardLis(pacMan));
        frame.setVisible(true);
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

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pink.update();
        red.update();
        pacMan.update();
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

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
    }
}
