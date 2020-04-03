package controll;

import mazeDataStructure.Direction;
import model.Entity;
import model.IGhost;
import model.IPacMan;

public class PathControll {

    public void setPathGhost(IGhost ghost) {

        //add code for path  mode

        if (ghost.getPositionOfEntity().getX() == ghost.getPositionOfEntity().getNextJunction().getxPos() && ghost.getPositionOfEntity().getY() == ghost.getPositionOfEntity().getNextJunction().getyPos()) {
            ghost.calculatePath();
        }
    }

    public void setPathPacMan(IPacMan pacMan) {
            if (pacMan.getPositionOfEntity().getX() == pacMan.getPositionOfEntity().getNextJunction().getxPos() && pacMan.getPositionOfEntity().getY() == pacMan.getPositionOfEntity().getNextJunction().getyPos()) {
                pacMan.setMoveDirection(pacMan.getDirectionQ());
                pacMan.updatePacPosition();
            }
    }
}
