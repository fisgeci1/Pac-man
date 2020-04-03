package model;

import controll.GoalFinding;
import mazeDataStructure.Direction;
import mazeDataStructure.Junction;
import mazeDataStructure.SearchAlgorithm;

public class Ghost extends Entity implements IGhost {

    private GhostType ghostType;
    private IPacMan pacMan;
    private MoveType moveType = MoveType.CHASE;
    private SearchAlgorithm searchAlgorithm;


    public Ghost(Position position, GhostType ghostType, SearchAlgorithm searchAlgorithm, IPacMan pacMan) {
        super(position);
        this.ghostType = ghostType;
        this.searchAlgorithm = searchAlgorithm;
        this.pacMan = pacMan;
    }

    public Direction calculatePath() {
        Direction direction = Direction.LEFT;
        GoalFinding goalFinding = new GoalFinding();
        Junction goalJunction = goalFinding.findEndGoal(pacMan.getPositionOfEntity(), ghostType, moveType);

        direction = searchAlgorithm.uniformCostSearch(getPositionOfEntity().getCurrentJunction(), goalJunction);

        switch (direction) {
            case LEFT:
                super.updatePosition(getPositionOfEntity().getX(), getPositionOfEntity().getY(), getPositionOfEntity().getCurrentJunction().getWestNeighbour());
                super.setMoveDirection(direction);
                break;
            case RIGHT:
                super.updatePosition(getPositionOfEntity().getX(), getPositionOfEntity().getY(), getPositionOfEntity().getCurrentJunction().getEastNeighbour());
                super.setMoveDirection(direction);
                break;
            case BOTTOM:
                super.updatePosition(getPositionOfEntity().getX(), getPositionOfEntity().getY(), getPositionOfEntity().getCurrentJunction().getSouthNeighbour());
                super.setMoveDirection(direction);
                break;
            case TOP:
                super.updatePosition(getPositionOfEntity().getX(), getPositionOfEntity().getY(), getPositionOfEntity().getCurrentJunction().getNorthNeighbour());
                super.setMoveDirection(direction);
                break;
        }


        return direction;
    }


    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }
}
