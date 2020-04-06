package model;

import controll.GoalFinding;
import mazeDataStructure.Direction;
import mazeDataStructure.Junction;
import mazeDataStructure.Maze;
import mazeDataStructure.SearchAlgorithm;

public class Ghost extends Entity implements IGhost {

    private GhostType ghostType;
    private IPacMan pacMan;
    private MoveType moveType = MoveType.CHASE;
    private SearchAlgorithm searchAlgorithm;
    private boolean isReturningToBase = false;
    private boolean alligned = false;

    public Ghost(Position position, GhostType ghostType, SearchAlgorithm searchAlgorithm, IPacMan pacMan) {
        super(position);
        this.ghostType = ghostType;
        this.searchAlgorithm = searchAlgorithm;
        this.pacMan = pacMan;
    }

    public Direction calculatePath() {
        Direction direction = Direction.LEFT;
        GoalFinding goalFinding = new GoalFinding();

        if (!isReturningToBase) {
            Junction goalJunction = goalFinding.findEndGoal(pacMan.getPositionOfEntity(), ghostType, moveType);
            setSpeed(1);
            alligned = false;
            direction = searchAlgorithm.uniformCostSearch(getPositionOfEntity().getCurrentJunction(), goalJunction);

            if (direction == null) {
                switch (ghostType) {
                    case RED:
                        direction = searchAlgorithm.uniformCostSearch(getPositionOfEntity().getNextJunction(), pacMan.getPositionOfEntity().getNextJunction());
                        break;
                    case PINK:
                        direction = searchAlgorithm.uniformCostSearch(getPositionOfEntity().getCurrentJunction(), pacMan.getPositionOfEntity().getCurrentJunction());
                        break;
                    case ORANGE:
                        break;
                    case BLUE:
                        break;
                }
            }
            setDiretcionOfGhost(direction);
        } else {
            Maze maze = searchAlgorithm.getMaze();
            Junction goal = null;

            switch (ghostType) {
                case RED:
                    goal = maze.getJunctionHashMap().get("n21");
                    break;
                case PINK:
                    goal = maze.getJunctionHashMap().get("n20");
                    break;
                case ORANGE:
                    break;
                case BLUE:
                    break;
            }

            int speed = 5;

            if (!alligned) {
                if (getPositionOfEntity().getCurrentJunction().getxPos() != getPositionOfEntity().getX()) {
                    speed = Math.abs(getPositionOfEntity().getX() - getPositionOfEntity().getNextJunction().getxPos());
                } else if (getPositionOfEntity().getCurrentJunction().getyPos() != getPositionOfEntity().getY()) {
                    speed = Math.abs(getPositionOfEntity().getY() - getPositionOfEntity().getNextJunction().getyPos());
                } else {
                    alligned = true;
                }
            }
            setSpeed(speed);

            setDiretcionOfGhost(searchAlgorithm.uniformCostSearch(getPositionOfEntity().getCurrentJunction(), goal));
            if (getPositionOfEntity().getCurrentJunction() == goal) {
                setReturningToBase(false);
            }
        }


        return direction;
    }


    private void setDiretcionOfGhost(Direction diretcionOfGhost) {
        switch (diretcionOfGhost) {
            case LEFT:
                super.updatePosition(getPositionOfEntity().getX(), getPositionOfEntity().getY(), getPositionOfEntity().getCurrentJunction().getWestNeighbour());
                super.setMoveDirection(diretcionOfGhost);
                break;
            case RIGHT:
                super.updatePosition(getPositionOfEntity().getX(), getPositionOfEntity().getY(), getPositionOfEntity().getCurrentJunction().getEastNeighbour());
                super.setMoveDirection(diretcionOfGhost);
                break;
            case BOTTOM:
                super.updatePosition(getPositionOfEntity().getX(), getPositionOfEntity().getY(), getPositionOfEntity().getCurrentJunction().getSouthNeighbour());
                super.setMoveDirection(diretcionOfGhost);
                break;
            case TOP:
                super.updatePosition(getPositionOfEntity().getX(), getPositionOfEntity().getY(), getPositionOfEntity().getCurrentJunction().getNorthNeighbour());
                super.setMoveDirection(diretcionOfGhost);
                break;
        }
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public void setReturningToBase(boolean returningToBase) {
        isReturningToBase = returningToBase;
    }

    @Override
    public boolean getReturningToBase() {
        return false;
    }
}
