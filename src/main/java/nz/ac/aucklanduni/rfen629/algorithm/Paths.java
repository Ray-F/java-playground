package nz.ac.aucklanduni.rfen629.algorithm;

import java.util.HashSet;

/**
 * @author Raymond Feng (raymond@fundafuture.co.nz)
 */
public class Paths {

    private static final HashSet<Integer> visited = new HashSet<>();

    /*
     * 0 1 2 3
     * 1 0 1 0
     * 2 1 0 0
     * 3 0 1 0
     */
    public boolean pathExistence(int[][] vertices, int start, int end) {
        int gridSize = vertices.length;

        int[] children = vertices[start];

        if (start == end) {
            return true;
        }

        for (int i = 0; i < gridSize; i++) {
            visited.add(start);

            // If the child has not been visited
            if (children[i] == 1 && !visited.contains(children[i]))  {
                return pathExistence(vertices, children[i], end);
            }
        }

        return false;
    }

}
