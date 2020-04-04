package controll;

import drawing.Frame;
import drawing.GamePanel;
import mazeDataStructure.Junction;
import mazeDataStructure.JunctionFactory;
import mazeDataStructure.SearchAlgorithm;
import model.*;

import javax.swing.*;
import java.util.HashMap;

public class SetUpGame {
    Frame frame;

    public SetUpGame() {


        JunctionFactory junctionL = new JunctionFactory();
        HashMap<String, Entity> entityHashMap = new HashMap<>();
        SearchAlgorithm searchAlgorithm = new SearchAlgorithm(junctionL.getMaze());
        IPacMan pacman = new PacMan(new Position(10, 10, junctionL.getMaze().getJunctionHashMap().get("n1"), junctionL.getMaze().getJunctionHashMap().get("n2")));
        IGhost red = new Ghost(new Position(60, 40, junctionL.getMaze().getJunctionHashMap().get("n21"), junctionL.getMaze().getJunctionHashMap().get("n21")), GhostType.RED, searchAlgorithm, pacman);
        IGhost pink = new Ghost(new Position(80, 40, junctionL.getMaze().getJunctionHashMap().get("n20"), junctionL.getMaze().getJunctionHashMap().get("n20")), GhostType.PINK, searchAlgorithm, pacman);

        entityHashMap.put("pacman", (Entity) pacman);
        entityHashMap.put("red", (Entity) red);
        entityHashMap.put("pink", (Entity) pink);

        frame = new Frame(800, 600, entityHashMap);
    }

    public void start() {
        frame.startGame();
    }
}
