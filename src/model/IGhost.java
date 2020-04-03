package model;

import mazeDataStructure.Direction;

import java.awt.*;

public interface IGhost {

    public Direction calculatePath();

    public void update();

    public void show(Graphics2D graphics2D);

    public Position getPositionOfEntity();
}
