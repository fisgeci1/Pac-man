package controll;

import mazeDataStructure.Junction;
import model.*;

public class GoalFinding {


    public Junction findEndGoal(Position pacManPosition, GhostType ghostType, MoveType moveType) {
        Junction endGoal = null;

        System.out.println( ghostType);
        if (moveType == MoveType.CHASE) {
            switch (ghostType) {
                case RED:
                    endGoal = pacManPosition.getCurrentJunction();
                    break;
                case PINK:
                    endGoal = pacManPosition.getNextJunction();
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
                    break;
                case PINK:
                    break;
                case ORANGE:
                    break;
                case BLUE:
                    break;
            }
        } else {
            // go to spawn
        }

        return endGoal;
    }
}
