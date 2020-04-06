package mazeDataStructure;

import java.util.*;

public class SearchAlgorithm {

    private Maze maze;

    public SearchAlgorithm(Maze maze) {
        this.maze = maze;
    }

    public Direction uniformCostSearch(Junction start, Junction endGoal) {
        List<Direction> path = new ArrayList<>();
        HashMap<Junction, Integer> bestScore = new HashMap<>();
        int pathCost = 0;
        Comparator<Junction> comparator = new Comparator<Junction>() {
            @Override
            public int compare(Junction o1, Junction o2) {
                if (o1.getWeight() < o2.getWeight()) {
                    return -1;
                } else if (o1.getWeight() > o2.getWeight()) {
                    return 1;
                }
                return 0;
            }
        };
        PriorityQueue<Junction> queue = new PriorityQueue<>(50, comparator);
        Set<Junction> explored = new HashSet<Junction>();
        boolean found = false;

        queue.add(start);
        do {

            Junction current = queue.poll();

            explored.add(current);


            if (current.equals(endGoal)) {
                found = true;

            }

            for (Junction neighbour : current.getAllNeighbours()) {
                neighbour.setWeight(pathCost + neighbour.getWeight());
                if (!queue.contains(neighbour) && !explored.contains(neighbour)) {
                    queue.add(neighbour);
                    neighbour.setParent(current);
                    pathCost += neighbour.getWeight();
                } else if (queue.contains(neighbour) && (neighbour.getWeight() > pathCost)) {
                    neighbour.setParent(current);
                    current = neighbour;
                    pathCost = neighbour.getWeight();

                }
            }


        } while (!queue.isEmpty());


        Direction direction = getDirection(endGoal);
        maze.resetMazeWeight();
        return direction;
    }

    private Direction getDirection(Junction target) {
        Direction direction = null;
        List<Junction> path = new ArrayList<>();
        for (Junction node = target; node != null; node = node.getParent()) {
            path.add(node);
        }

        if (path.size() > 1) {
            Collections.reverse(path);
            Junction begining = path.get(0);
            path.remove(0);
            Junction secondMove = path.get(0);


            if (begining.getxPos() == secondMove.getxPos()) {
                if (begining.getyPos() - secondMove.getyPos() < 0) {
                    direction = Direction.BOTTOM;
                } else {
                    direction = Direction.TOP;
                }
            } else {
                if (begining.getxPos() - secondMove.getxPos() < 0) {
                    direction = Direction.RIGHT;
                } else {
                    direction = Direction.LEFT;
                }
            }
        }
        return direction;
    }

    public Maze getMaze() {
        return maze;
    }
}
