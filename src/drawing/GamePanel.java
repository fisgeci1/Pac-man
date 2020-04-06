package drawing;

import controll.PathControll;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GamePanel extends JPanel {

    private IGhost red;
    private IGhost pink;
    private IPacMan pacMan;
    private PathControll pathControll;
    private Dots[] energizer = new Dots[4];
    private List<Dots> food;
    ;

    public GamePanel(HashMap<String, Entity> entityHashMap) {
        pacMan = (IPacMan) entityHashMap.get("pacman");
        red = (IGhost) entityHashMap.get("red");
        pink = (IGhost) entityHashMap.get("pink");


        food = new ArrayList<>();
        energizer[0] = new Dots(10, 70, 5);
        energizer[1] = new Dots(120, 10, 5);
        energizer[2] = new Dots(120, 70, 5);
        energizer[3] = new Dots(35, 55, 5);


        setUpFood();

        pathControll = new PathControll(new IGhost[]{red, pink, null, null});

    }


    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.scale(5, 5);
        graphics2D.clearRect(0, 0, 800, 600);
        graphics2D.setColor(Color.gray);
        graphics2D.fillRect(0, 0, 800, 800);



        drawWalls(graphics2D);
        graphics2D.drawString("Score is: " + pacMan.getScore(), 10, 100);


        for (int i = 0; i < energizer.length; i++) {
            if (new Ellipse2D.Double(pacMan.getPositionOfEntity().getX(), pacMan.getPositionOfEntity().getY(), 5, 5).intersects(new Rectangle2D.Double(energizer[i].x, energizer[i].y, 5, 5))) {
                if (!energizer[i].isEaten()) {
                    energizer[i].setEaten(true);
                    pink.setMoveType(MoveType.FLEA);
                    red.setMoveType(MoveType.FLEA);
                }
            }
        }
        Rectangle pacmanRect = new Rectangle(pacMan.getPositionOfEntity().getX(), pacMan.getPositionOfEntity().getY(), 5, 5);

        for (Dots dot : food) {
            if (pacmanRect.intersects(new Rectangle2D.Double(dot.x, dot.y, 3, 3)) && !dot.isEaten()) {
                dot.setEaten(true);
                pacMan.setScore(pacMan.getScore() + 1);
            }
        }
        drawEnergizer(graphics2D);
        drawFood(graphics2D);
        pathControll.setPathGhost(red, pacMan);
        pathControll.setPathGhost(pink, pacMan);
        pathControll.setPathPacMan(pacMan);

        red.update();
        pacMan.update();
        pink.update();


        if (!(new Rectangle(red.getPositionOfEntity().getX(), red.getPositionOfEntity().getY(), 5, 5).intersects(new Rectangle(pink.getPositionOfEntity().getX(), pink.getPositionOfEntity().getY(), 5, 5)))) {
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        graphics2D.setColor(Color.MAGENTA);
        if (pink.getMoveType() == MoveType.FLEA) {
            graphics2D.setColor(Color.BLUE);
        }
        pink.show(graphics2D);
        graphics2D.setColor(Color.RED);
        if (red.getMoveType() == MoveType.FLEA) {
            graphics2D.setColor(Color.BLUE);
        }

        red.show(graphics2D);
        graphics2D.setColor(Color.YELLOW);
        pacMan.show(graphics2D);
        repaint();
    }


    private void drawEnergizer(Graphics2D graphics2D) {
        for (Dots dot : energizer) {
            if (!dot.isEaten()) {
                graphics2D.setColor(Color.GREEN);
                graphics2D.fill(dot);
            }
        }
    }

    private void drawFood(Graphics2D graphics2D) {
        for (Dots dot : food) {
            if (!dot.isEaten()) {
                graphics2D.setColor(Color.ORANGE);
                graphics2D.fill(dot);
            }
        }
    }

    private void setUpFood() {
        Dots d1 = new Dots(21, 11, 3);
        Dots d29 = new Dots(26, 11, 3);
        Dots d2 = new Dots(11, 11, 3);
        Dots d3 = new Dots(16, 11, 3);
        Dots d4 = new Dots(11, 16, 3);
        Dots d5 = new Dots(31, 11, 3);
        Dots d30 = new Dots(36, 11, 3);
        Dots d31 = new Dots(41, 11, 3);
        Dots d32 = new Dots(41, 16, 3);
        Dots d33 = new Dots(41, 21, 3);
        Dots d34 = new Dots(41, 26, 3);
        Dots d6 = new Dots(11, 21, 3);
        Dots d7 = new Dots(11, 26, 3);
        Dots d8 = new Dots(11, 31, 3);
        Dots d9 = new Dots(11, 36, 3);
        Dots d10 = new Dots(11, 41, 3);
        Dots d38 = new Dots(16, 41, 3);
        Dots d11 = new Dots(11, 46, 3);
        Dots d12 = new Dots(21, 41, 3);
        Dots d39 = new Dots(26, 41, 3);
        Dots d42 = new Dots(26, 36, 3);
        Dots d40 = new Dots(31, 41, 3);
        Dots d41 = new Dots(36, 41, 3);
        Dots d13 = new Dots(11, 51, 3);
        Dots d14 = new Dots(11, 56, 3);
        Dots d15 = new Dots(11, 61, 3);
        Dots d16 = new Dots(11, 66, 3);
        Dots d45 = new Dots(11, 71, 3);
        Dots d46 = new Dots(16, 71, 3);
        Dots d17 = new Dots(21, 71, 3);
        Dots d43 = new Dots(26, 71, 3);
        Dots d18 = new Dots(31, 71, 3);
        Dots d44 = new Dots(36, 71, 3);
        Dots d47 = new Dots(41, 71, 3);
        Dots d48 = new Dots(41, 66, 3);
        Dots d49 = new Dots(41, 61, 3);
        Dots d50 = new Dots(41, 56, 3);
        Dots d19 = new Dots(41, 41, 3);
        Dots d56 = new Dots(46, 41, 3);
        Dots d57 = new Dots(51, 41, 3);
        Dots d20 = new Dots(31, 56, 3);
        Dots d21 = new Dots(31, 56, 3);
        Dots d52 = new Dots(26, 56, 3);
        Dots d53 = new Dots(26, 51, 3);
        Dots d54 = new Dots(26, 46, 3);
        Dots d55 = new Dots(26, 41, 3);
        Dots d51 = new Dots(36, 56, 3);
        Dots d22 = new Dots(41, 31, 3);
        Dots d35 = new Dots(36, 31, 3);
        Dots d36 = new Dots(31, 31, 3);
        Dots d37 = new Dots(26, 31, 3);
        Dots d23 = new Dots(46, 31, 3);
        Dots d24 = new Dots(51, 31, 3);
        Dots d25 = new Dots(51, 16, 3);
        Dots d26 = new Dots(51, 11, 3);
        Dots d27 = new Dots(51, 21, 3);
        Dots d28 = new Dots(51, 26, 3);
        Dots d58 = new Dots(51, 31, 3);
        Dots d59 = new Dots(51, 36, 3);
        Dots d60 = new Dots(51, 46, 3);
        Dots d61 = new Dots(51, 51, 3);
        Dots d62 = new Dots(51, 56, 3);
        Dots d63 = new Dots(51, 61, 3);
        Dots d64 = new Dots(51, 66, 3);
        Dots d65 = new Dots(51, 71, 3);
        Dots d66 = new Dots(46, 56, 3);
        Dots d67 = new Dots(56, 11, 3);
        Dots d68 = new Dots(61, 11, 3);
        Dots d69 = new Dots(66, 11, 3);
        Dots d70 = new Dots(71, 11, 3);
        Dots d71 = new Dots(76, 11, 3);
        Dots d72 = new Dots(81, 11, 3);
        Dots d73 = new Dots(86, 11, 3);
        Dots d74 = new Dots(91, 11, 3);
        Dots d75 = new Dots(56, 71, 3);
        Dots d76 = new Dots(61, 71, 3);
        Dots d77 = new Dots(66, 71, 3);
        Dots d78 = new Dots(71, 71, 3);
        Dots d79 = new Dots(76, 71, 3);
        Dots d80 = new Dots(81, 71, 3);
        Dots d81 = new Dots(86, 71, 3);
        Dots d82 = new Dots(91, 71, 3);
        Dots d83 = new Dots(56, 31, 3);
        Dots d84 = new Dots(61, 31, 3);
        Dots d85 = new Dots(66, 31, 3);
        Dots d86 = new Dots(71, 31, 3);
        Dots d87 = new Dots(76, 31, 3);
        Dots d88 = new Dots(81, 31, 3);
        Dots d89 = new Dots(86, 31, 3);
        Dots d90 = new Dots(91, 31, 3);
        Dots d91 = new Dots(96, 31, 3);
        Dots d92 = new Dots(101, 31, 3);
        Dots d93 = new Dots(106, 31, 3);
        Dots d94 = new Dots(111, 31, 3);
        Dots d95 = new Dots(116, 31, 3);
        Dots d96 = new Dots(56, 56, 3);
        Dots d97 = new Dots(61, 56, 3);
        Dots d98 = new Dots(66, 56, 3);
        Dots d99 = new Dots(71, 56, 3);
        Dots d100 = new Dots(76, 56, 3);
        Dots d101 = new Dots(81, 56, 3);
        Dots d102 = new Dots(86, 56, 3);
        Dots d103 = new Dots(91, 56, 3);
        Dots d104 = new Dots(96, 56, 3);
        Dots d105 = new Dots(101, 56, 3);
        Dots d106 = new Dots(106, 56, 3);
        Dots d107 = new Dots(111, 56, 3);
        Dots d108 = new Dots(116, 56, 3);
        Dots d109 = new Dots(91, 16, 3);
        Dots d110 = new Dots(91, 21, 3);
        Dots d111 = new Dots(91, 26, 3);
        Dots d112 = new Dots(91, 36, 3);
        Dots d113 = new Dots(91, 41, 3);
        Dots d114 = new Dots(91, 46, 3);
        Dots d115 = new Dots(91, 51, 3);
        Dots d116 = new Dots(91, 61, 3);
        Dots d117 = new Dots(91, 66, 3);
        Dots d118 = new Dots(91, 66, 3);
        Dots d119 = new Dots(101, 11, 3);
        Dots d120 = new Dots(101, 16, 3);
        Dots d121 = new Dots(101, 21, 3);
        Dots d122 = new Dots(101, 26, 3);
        Dots d123 = new Dots(96, 41, 3);
        Dots d124 = new Dots(101, 41, 3);
        Dots d125 = new Dots(106, 41, 3);
        Dots d126 = new Dots(111, 41, 3);
        Dots d127 = new Dots(116, 41, 3);
        Dots d128 = new Dots(121, 41, 3);
        Dots d143 = new Dots(126, 41, 3);
        Dots d144 = new Dots(131, 41, 3);
        Dots d129 = new Dots(96, 56, 3);
        Dots d130 = new Dots(101, 56, 3);
        Dots d131 = new Dots(106, 56, 3);
        Dots d132 = new Dots(111, 56, 3);
        Dots d133 = new Dots(116, 56, 3);
        Dots d134 = new Dots(101, 61, 3);
        Dots d135 = new Dots(101, 66, 3);
        Dots d136 = new Dots(101, 71, 3);
        Dots d137 = new Dots(106, 11, 3);
        Dots d138 = new Dots(111, 11, 3);
        Dots d139 = new Dots(116, 11, 3);
        Dots d140 = new Dots(121, 11, 3);
        Dots d141 = new Dots(126, 11, 3);
        Dots d142 = new Dots(131, 11, 3);
        Dots d145 = new Dots(106, 71, 3);
        Dots d146 = new Dots(111, 71, 3);
        Dots d147 = new Dots(116, 71, 3);
        Dots d148 = new Dots(121, 71, 3);
        Dots d149 = new Dots(126, 71, 3);
        Dots d150 = new Dots(131, 71, 3);
        Dots d151 = new Dots(131, 16, 3);
        Dots d152 = new Dots(131, 21, 3);
        Dots d153 = new Dots(131, 26, 3);
        Dots d154 = new Dots(131, 31, 3);
        Dots d155 = new Dots(131, 36, 3);
        Dots d156 = new Dots(131, 46, 3);
        Dots d157 = new Dots(131, 51, 3);
        Dots d158 = new Dots(131, 56, 3);
        Dots d159 = new Dots(131, 61, 3);
        Dots d160 = new Dots(131, 66, 3);

        food.add(d2);
        food.add(d1);
        food.add(d3);
        food.add(d4);
        food.add(d5);
        food.add(d6);
        food.add(d7);
        food.add(d8);
        food.add(d9);
        food.add(d10);
        food.add(d11);
        food.add(d12);
        food.add(d13);
        food.add(d14);
        food.add(d15);
        food.add(d16);
        food.add(d17);
        food.add(d18);
        food.add(d19);
        food.add(d20);
        food.add(d21);
        food.add(d22);
        food.add(d23);
        food.add(d24);
        food.add(d25);
        food.add(d26);
        food.add(d27);
        food.add(d28);
        food.add(d29);
        food.add(d30);
        food.add(d31);
        food.add(d32);
        food.add(d33);
        food.add(d34);
        food.add(d35);
        food.add(d36);
        food.add(d37);
        food.add(d38);
        food.add(d39);
        food.add(d40);
        food.add(d41);
        food.add(d42);
        food.add(d43);
        food.add(d44);
        food.add(d45);
        food.add(d46);
        food.add(d47);
        food.add(d48);
        food.add(d49);
        food.add(d50);
        food.add(d51);
        food.add(d52);
        food.add(d53);
        food.add(d54);
        food.add(d55);
        food.add(d56);
        food.add(d57);
        food.add(d58);
        food.add(d59);
        food.add(d60);
        food.add(d61);
        food.add(d62);
        food.add(d63);
        food.add(d64);
        food.add(d65);
        food.add(d66);
        food.add(d67);
        food.add(d68);
        food.add(d69);
        food.add(d70);
        food.add(d71);
        food.add(d72);
        food.add(d73);
        food.add(d74);
        food.add(d75);
        food.add(d76);
        food.add(d77);
        food.add(d78);
        food.add(d79);
        food.add(d80);
        food.add(d81);
        food.add(d82);
        food.add(d83);
        food.add(d84);
        food.add(d85);
        food.add(d86);
        food.add(d87);
        food.add(d88);
        food.add(d89);
        food.add(d90);
        food.add(d91);
        food.add(d92);
        food.add(d93);
        food.add(d94);
        food.add(d95);
        food.add(d96);
        food.add(d97);
        food.add(d98);
        food.add(d99);
        food.add(d100);
        food.add(d101);
        food.add(d102);
        food.add(d103);
        food.add(d104);
        food.add(d105);
        food.add(d106);
        food.add(d107);
        food.add(d108);
        food.add(d109);
        food.add(d110);
        food.add(d111);
        food.add(d112);
        food.add(d113);
        food.add(d114);
        food.add(d115);
        food.add(d116);
        food.add(d117);
        food.add(d118);
        food.add(d119);
        food.add(d120);
        food.add(d121);
        food.add(d122);
        food.add(d123);
        food.add(d124);
        food.add(d125);
        food.add(d126);
        food.add(d127);
        food.add(d128);
        food.add(d129);
        food.add(d130);
        food.add(d131);
        food.add(d132);
        food.add(d133);
        food.add(d134);
        food.add(d135);
        food.add(d136);
        food.add(d137);
        food.add(d138);
        food.add(d139);
        food.add(d140);
        food.add(d141);
        food.add(d142);
        food.add(d143);
        food.add(d144);
        food.add(d145);
        food.add(d146);
        food.add(d147);
        food.add(d148);
        food.add(d149);
        food.add(d150);
        food.add(d151);
        food.add(d152);
        food.add(d153);
        food.add(d154);
        food.add(d155);
        food.add(d156);
        food.add(d157);
        food.add(d158);
        food.add(d159);
        food.add(d160);

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
