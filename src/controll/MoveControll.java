package controll;

import model.MoveType;

public class MoveControll {


    public static MoveType getMoveType() {
        int random = (int) (Math.random() * 100);
        System.out.println(random);
        if (random > 10) {
            return MoveType.CHASE;
        }
        return MoveType.SCATTER;
    }
}
