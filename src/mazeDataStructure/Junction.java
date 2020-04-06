package mazeDataStructure;

import java.util.ArrayList;
import java.util.List;

public class Junction {

    private Junction northNeighbour;
    private Junction eastNeighbour;
    private Junction westNeighbour;
    private Junction southNeighbour;
    private int xPos;
    private int yPos;
    private int weight;
    private Junction parent;
    private String name;


    public Junction(String name, int xPos, int yPos, Junction northNeighbour, Junction eastNeighbour, Junction westNeighbour, Junction southNeighbour) {
        this.northNeighbour = northNeighbour;
        this.eastNeighbour = eastNeighbour;
        this.westNeighbour = westNeighbour;
        this.southNeighbour = southNeighbour;
        this.name = name;

        if (northNeighbour != null) {
            northNeighbour.setSouthNeighbour(this);
            northNeighbour.setWeight(getDistance(this.xPos, northNeighbour.getxPos(), this.yPos, northNeighbour.getyPos()));
        }
        if (eastNeighbour != null) {
            eastNeighbour.setWestNeighbour(this);
            eastNeighbour.setWeight(getDistance(this.xPos, eastNeighbour.getxPos(), this.yPos, eastNeighbour.getyPos()));
        }
        if (westNeighbour != null) {
            westNeighbour.setEastNeighbour(this);
            westNeighbour.setWeight(getDistance(this.xPos, westNeighbour.getxPos(), this.yPos, westNeighbour.getyPos()));
        }
        if (southNeighbour != null) {
            southNeighbour.setNorthNeighbour(this);
            southNeighbour.setWeight(getDistance(this.xPos, southNeighbour.getxPos(), this.yPos, southNeighbour.getyPos()));
        }


        this.xPos = xPos;
        this.yPos = yPos;
    }

    private int getDistance(int firstX, int secondX, int firstY, int secondY) {
        int distanceBetweenPoints;
        distanceBetweenPoints = (int) Math.sqrt(Math.pow(firstX - secondX, 2) + Math.pow(firstY + secondY, 2));
        return distanceBetweenPoints;
    }

    public void reset() {
        parent = null;
        if (northNeighbour != null) {
            northNeighbour.setWeight(getDistance(this.xPos, northNeighbour.getxPos(), this.yPos, northNeighbour.getyPos()));
        }
        if (eastNeighbour != null) {
            eastNeighbour.setWeight(getDistance(this.xPos, eastNeighbour.getxPos(), this.yPos, eastNeighbour.getyPos()));
        }
        if (westNeighbour != null) {
            westNeighbour.setWeight(getDistance(this.xPos, westNeighbour.getxPos(), this.yPos, westNeighbour.getyPos()));
        }
        if (southNeighbour != null) {
            southNeighbour.setWeight(getDistance(this.xPos, southNeighbour.getxPos(), this.yPos, southNeighbour.getyPos()));
        }
    }

    public List<Junction> getAllNeighbours() {
        List<Junction> neighbours = new ArrayList<>();

        if (northNeighbour != null) {
            neighbours.add(northNeighbour);
        }
        if (eastNeighbour != null) {
            neighbours.add(eastNeighbour);
        }
        if (westNeighbour != null) {
            neighbours.add(westNeighbour);
        }
        if (southNeighbour != null) {
            neighbours.add(southNeighbour);
        }
        return neighbours;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }


    public int getyPos() {
        return yPos;
    }

    public Junction getParent() {
        return parent;
    }

    public void setParent(Junction parent) {
        this.parent = parent;
    }

    public Junction getNorthNeighbour() {
        return northNeighbour;
    }

    public void setNorthNeighbour(Junction northNeighbour) {
        this.northNeighbour = northNeighbour;
    }

    public Junction getEastNeighbour() {
        return eastNeighbour;
    }

    public void setEastNeighbour(Junction eastNeighbour) {
        this.eastNeighbour = eastNeighbour;
    }

    public Junction getWestNeighbour() {
        return westNeighbour;
    }

    public void setWestNeighbour(Junction westNeighbour) {
        this.westNeighbour = westNeighbour;
    }

    public Junction getSouthNeighbour() {
        return southNeighbour;
    }

    public void setSouthNeighbour(Junction southNeighbour) {
        this.southNeighbour = southNeighbour;
    }

    public String getName() {
        return name;
    }

}
