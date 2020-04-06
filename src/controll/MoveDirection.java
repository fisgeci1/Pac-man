package controll;

import mazeDataStructure.Direction;

public class MoveDirection {

    private int xDir = 1;
    private int yDir = 0;
    private int speed = 1;


    public void setMoveDir(Direction dir) {
        switch (dir) {
            case LEFT:
                xDir = -speed;
                yDir = 0;
                break;
            case RIGHT:
                xDir = speed;
                yDir = 0;
                break;
            case BOTTOM:
                xDir = 0;
                yDir = speed;
                break;
            case TOP:
                xDir = 0;
                yDir = -speed;
                break;
            case STATIONARY:
                xDir = 0;
                yDir = 0;
                break;
        }

    }

    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }

    public int getxDir() {
        return xDir;
    }

    public int getyDir() {
        return yDir;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
