package nz.ac.aucklanduni.rfen629.problems;

public class MinimumSums {

    /*
     * LeetCode 64
     * https://leetcode.com/problems/minimum-path-sum/
     */
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] sumGrid = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int top = (i > 0) ? sumGrid[i - 1][j] : -1;
                int left = (j > 0) ? sumGrid[i][j - 1] : -1;

                int toAdd = grid[i][j];
                if (top != -1 && left != -1) {
                    toAdd += Math.min(left, top);
                } else if (top == -1 && left == -1) {
                    toAdd += 0;
                } else {
                    toAdd += (top == -1) ? left : top;
                }

                sumGrid[i][j] = toAdd;
            }
        }

        return sumGrid[r - 1][c - 1];
    }

}
