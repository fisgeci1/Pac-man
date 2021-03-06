package model;

import mazeDataStructure.Direction;

import java.awt.*;

public interface IGhost {

    public Direction calculatePath();

    public void update();

    public void show(Graphics2D graphics2D);

    public Position getPositionOfEntity();

    public void setReturningToBase(boolean returningToBase);

    public boolean getReturningToBase();

    public MoveType getMoveType();

    public void setMoveType(MoveType moveType);

}
