package controll;

import model.GhostType;
import model.IGhost;
import model.IPacMan;
import model.MoveType;

import java.awt.*;

public class PathControll {

    private boolean checkIfEaten = false;
    private int moveDecidingCoolDown = 200;
    private int fleaCooldown = 200;
    private IGhost[] ghosts;
    private int ghostAte = 0;

    public PathControll(IGhost[] ghosts) {
        this.ghosts = ghosts;
    }


    public void setPathGhost(IGhost ghost, IPacMan pacMan) {


        checkIfEaten = checkIfEaten(ghost, pacMan);


        if (!checkIfEaten) {
            if (ghost.getMoveType() == MoveType.FLEA && fleaCooldown == 0) {
                fleaCooldown = 200;
                moveDecidingCoolDown = 50;
                ghosts[0].setMoveType(MoveType.CHASE);
                ghosts[1].setMoveType(MoveType.CHASE);
                ghostAte = 0;
            } else if (ghost.getMoveType() == MoveType.FLEA) {
                fleaCooldown--;
            }


            if (ghost.getMoveType() != MoveType.FLEA && !ghost.getReturningToBase() && moveDecidingCoolDown == 0) {

                MoveType moveType = MoveControll.getMoveType();
                ghosts[0].setMoveType(moveType);
                ghosts[1].setMoveType(moveType);


                moveDecidingCoolDown = (moveType == MoveType.SCATTER) ? 50 : 1000;
            }
            moveDecidingCoolDown--;
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

            ghostAte++;
            pacMan.setScore(pacMan.getScore() + 10 * ghostAte);
            if (ghost.getMoveType() != MoveType.FLEA) {
            }
            return true;
        }
        return false;
    }
}
