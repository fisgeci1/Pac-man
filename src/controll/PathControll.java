package controll;

import mazeDataStructure.Direction;
import model.Entity;
import model.IGhost;
import model.IPacMan;

import java.awt.*;

public class PathControll {

    private boolean checkIfEaten = false;

    public void setPathGhost(IGhost ghost, IPacMan pacMan) {


            checkIfEaten = checkIfEaten(ghost, pacMan);

        if (!checkIfEaten) {
            if (ghost.getPositionOfEntity().getX() == ghost.getPositionOfEntity().getNextJunction().getxPos() && ghost.getPositionOfEntity().getY() == ghost.getPositionOfEntity().getNextJunction().getyPos()) {
                ghost.calculatePath();
            }
        } else {
            ghost.setReturningToBase(true);
            if (ghost.getPositionOfEntity().getX() == ghost.getPositionOfEntity().getNextJunction().getxPos() && ghost.getPositionOfEntity().getY() == ghost.getPositionOfEntity().getNextJunction().getyPos()) {
                ghost.calculatePath();
            }
        }
    }

    public void setPathPacMan(IPacMan pacMan) {
        if (pacMan.getPositionOfEntity().getX() == pacMan.getPositionOfEntity().getNextJunction().getxPos() && pacMan.getPositionOfEntity().getY() == pacMan.getPositionOfEntity().getNextJunction().getyPos()) {
            pacMan.setMoveDirection(pacMan.getDirectionQ());
            pacMan.updatePacPosition();
        }
    }


    public boolean checkIfEaten(IGhost ghost, IPacMan pacMan) {
        Rectangle pacManRect = new Rectangle(pacMan.getPositionOfEntity().getX(), pacMan.getPositionOfEntity().getY(), 5, 5);
        Rectangle ghostRect = new Rectangle(ghost.getPositionOfEntity().getX(), ghost.getPositionOfEntity().getY(), 5, 5);
        if (pacManRect.intersects(ghostRect)) {
            return true;
        }
        return false;
    }
}
