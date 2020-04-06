package model;

import java.awt.*;

public class Dots extends Rectangle {

    private int xPos, yPos, size;
    private boolean eaten = false;

    public Dots(int xPos, int yPos, int size) {
        super(xPos, yPos, size, size);
        this.xPos = xPos;
        this.yPos = yPos;
        this.size = size;
    }


    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    public boolean isEaten() {
        return eaten;
    }
}
r