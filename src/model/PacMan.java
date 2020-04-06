package model;

import controll.MoveDirection;
import mazeDataStructure.Direction;
import mazeDataStructure.Junction;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

public class PacMan extends Entity implements IPacMan {
    private Direction directionQ = Direction.TOP;
    private int startAngle = 90;
    private int endAngle = 270;
    private int offset = 5;
    private int eyeXpos = 0;
    private int eyeYpos = 2;
    private int sign = 1;
    private int endSign = 1;
    private int score = 0;
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
        rotate();
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
    public void show(Graphics2D graphics2D) {

        graphics2D.fillArc(getPositionOfEntity().getX(), getPositionOfEntity().getY(), 5, 5, startAngle, endAngle);
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillOval(getPositionOfEntity().getX() + eyeXpos, getPositionOfEntity().getY() + eyeYpos, 1, 1);

        startAngle = startAngle - offset * sign;
        endAngle = endAngle + offset * endSign;
        if (startAngle * sign == 15 * sign || startAngle == 225) {
            offset = 0;
            sign *= -1;
            endSign *= -1;

        } else if (startAngle * sign == 90 * sign || startAngle * sign == 165 * sign || startAngle * sign == 300 * sign) {
            offset = 0;
            sign *= -1;
            endSign *= -1;
        }
        offset += 5;

    }

    private void rotate() {
        eyeXpos = 0;
        eyeYpos = 2;
        switch (directionQ) {
            case LEFT:
                startAngle = 90;
                endAngle = -270;
                offset = 5;
                sign = -1;
                endSign = -1;
                eyeXpos = 4;
                eyeYpos = 2;

                break;
            case RIGHT:
                startAngle = 90;
                endAngle = 270;
                sign = 1;
                offset = 5;
                endSign = 1;
                break;
            case BOTTOM:
                startAngle = 225;
                endAngle = -270;
                sign = -1;
                offset = 5;
                endSign = -1;
                break;
            case TOP:
                startAngle = 135;
                endAngle = 270;
                sign = -1;
                offset = 5;
                endSign = -1;
                break;
            case STATIONARY:
                break;
        }
    }

    @Override
    public Direction getDirectionQ() {
        return directionQ;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
