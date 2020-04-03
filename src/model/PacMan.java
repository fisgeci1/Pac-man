package model;

import controll.MoveDirection;
import mazeDataStructure.Direction;
import mazeDataStructure.Junction;

public class PacMan extends Entity implements IPacMan {
    private Direction directionQ = Direction.TOP;
    private Direction direction = Direction.TOP;

    private MoveDirection moveDirection = new MoveDirection();

    public PacMan(Position position) {
        super(position);
    }


    public void setDirectionQ(Direction directionQ) {
        this.directionQ = directionQ;
        boolean deadEnd = false;

        deadEnd = checkIfDeadEnd();

        if (!deadEnd) {
            moveDirection.setMoveDir(directionQ);
        } else {
            directionQ = Direction.STATIONARY;
        }
    }


    private boolean checkIfDeadEnd() {
        boolean isDeadEnd = false;
        switch (directionQ) {
            case LEFT:
                isDeadEnd = super.getPositionOfEntity().getCurrentJunction().getWestNeighbour() == null;
                break;
            case RIGHT:
                isDeadEnd = super.getPositionOfEntity().getCurrentJunction().getEastNeighbour() == null;
                break;
            case BOTTOM:
                isDeadEnd = super.getPositionOfEntity().getCurrentJunction().getSouthNeighbour() == null;
                break;
            case TOP:
                isDeadEnd = super.getPositionOfEntity().getCurrentJunction().getNorthNeighbour() == null;
                break;
        }
        return isDeadEnd;
    }

    @Override
    public void updatePacPosition() {

        if (getNextJunction() != null) {
            super.updatePosition(getPositionOfEntity().getX(), getPositionOfEntity().getY(), getPositionOfEntity().getNextJunction(), getNextJunction());
        } else {
            getMoveDirection().setyDir(0);
            getMoveDirection().setxDir(0);
        }
    }

    private Junction getNextJunction() {
        switch (directionQ) {
            case LEFT:
                return getPositionOfEntity().getNextJunction().getWestNeighbour();
            case RIGHT:
                return getPositionOfEntity().getNextJunction().getEastNeighbour();
            case BOTTOM:
                return getPositionOfEntity().getNextJunction().getSouthNeighbour();
            case TOP:
                return getPositionOfEntity().getNextJunction().getNorthNeighbour();
            default:
                return getPositionOfEntity().getNextJunction();
        }
    }


    @Override
    public Direction getDirectionQ() {
        return directionQ;
    }
}
