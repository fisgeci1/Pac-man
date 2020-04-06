package controll;

import mazeDataStructure.Junction;
import mazeDataStructure.Maze;
import model.*;

public class GoalFinding {

    private Maze maze;


    public GoalFinding(Maze maze) {
        this.maze = maze;
    }

    public Junction findEndGoal(Position pacManPosition, Position ghostPosition, GhostType ghostType, MoveType moveType) {
        Junction endGoal = null;

        if (moveType == MoveType.CHASE) {
            switch (ghostType) {
                case RED:
                    endGoal = pacManPosition.getCurrentJunction();
                    if (endGoal == null) {
                        endGoal = pacManPosition.getNextJunction();
                    }
                    break;
                case PINK:
                    endGoal = pacManPosition.getNextJunction();
                    if (endGoal == null) {
                        endGoal = pacManPosition.getCurrentJunction();
                    }
                    break;
                case ORANGE:
                    //random
                    break;
                case BLUE:
                    //code to chase till close then scatter
                    break;
            }
        } else if (moveType == MoveType.SCATTER) {
            switch (ghostType) {
                case RED:
                    endGoal = maze.getJunctionHashMap().get("n34");
                    if (ghostPosition.getCurrentJunction() == endGoal) {
                        endGoal = maze.getJunctionHashMap().get("n33");
                    }
                    break;
                case PINK:
                    endGoal = maze.getJunctionHashMap().get("n1");
                    if (ghostPosition.getCurrentJunction() == endGoal) {
                        endGoal = maze.getJunctionHashMap().get("n2");
                    }
                    break;
                case ORANGE:
                    break;
                case BLUE:
                    break;
            }
        } else if (moveType == MoveType.FLEA) {

            int random = (int) (Math.random() * 33 + 1);

            endGoal = maze.getJunctionHashMap().get("n" + random);

        }

        return endGoal;
    }
}
