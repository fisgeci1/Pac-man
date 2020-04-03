package mazeDataStructure;

import java.util.HashMap;
import java.util.List;

public class Maze {

    private HashMap<String, Junction> junctionHashMap;

    public Maze(HashMap<String, Junction> list) {
        junctionHashMap = list;

    }

    public HashMap<String, Junction> getJunctionHashMap() {
        return junctionHashMap;
    }

    public void resetMazeWeight() {
        junctionHashMap.forEach((name, junction) -> junction.reset());
    }
}
