package model;

import mazeDataStructure.Junction;

public class Position {

    private int x, y;
    private Junction currentJunction;
    private Junction nextJunction;

    public Position(int x, int y, Junction currentJunction, Junction nextJunction) {
        this.x = x;
        this.y=  y;
        this.currentJunction = currentJunction;
        this.nextJunction = nextJunction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Junction getCurrentJunction() {
        return currentJunction;
    }

    public Junction getNextJunction() {
        return nextJunction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCurrentJunction(Junction currentJunction) {
        this.currentJunction = currentJunction;
    }

    public void setNextJunction(Junction nextJunction) {
        this.nextJunction = nextJunction;
    }
}
