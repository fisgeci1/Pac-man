package model;

import controll.MoveDirection;
import mazeDataStructure.Direction;
import mazeDataStructure.Junction;

import java.awt.*;

public class Entity {

    private Position positionOfEntity;
    private MoveDirection moveDirection;


    public Entity(Position position) {
        positionOfEntity = position;
        moveDirection = new MoveDirection();
    }


    public Position getPositionOfEntity() {
        return positionOfEntity;
    }


    public void updatePosition(int x, int y) {
        positionOfEntity.setX(x);
        positionOfEntity.setY(y);
    }

    public void setSpeed(int speed) {
        moveDirection.setSpeed(speed);
    }

    public void updatePosition(int x, int y, Junction nextJunction) {
        updatePosition(x, y);
        positionOfEntity.setCurrentJunction(nextJunction);
        positionOfEntity.setNextJunction(nextJunction);
    }

    public void setMoveDirection(Direction direction) {
        moveDirection.setMoveDir(direction);
    }

    public MoveDirection getMoveDirection() {
        return moveDirection;
    }

    public void update() {
        updatePosition(positionOfEntity.getX() + moveDirection.getxDir(), positionOfEntity.getY() + moveDirection.getyDir());
    }

    public void show(Graphics2D graphics2D) {
        graphics2D.fillOval(getPositionOfEntity().getX(), getPositionOfEntity().getY(), 5, 5);
    }

    public void updatePosition(int x, int y, Junction currentJunction, Junction nextJunction) {

        positionOfEntity.setCurrentJunction(currentJunction);
        positionOfEntity.setNextJunction(nextJunction);
    }
}
