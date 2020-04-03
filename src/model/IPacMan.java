package model;

import mazeDataStructure.Direction;

import java.awt.*;

public interface IPacMan {

    public void setDirectionQ(Direction directionQ);

    public void update();

    public Position getPositionOfEntity();

    public Direction getDirectionQ();

    public void updatePacPosition();

    public void setMoveDirection(Direction direction);

    public void show(Graphics2D graphics2D);
}
