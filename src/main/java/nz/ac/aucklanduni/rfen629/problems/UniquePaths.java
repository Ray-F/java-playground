package nz.ac.aucklanduni.rfen629.problems;

public class UniquePaths {

	/*
	 * LeetCode 62
	 * https://leetcode.com/problems/unique-paths/
	 */
	public int uniquePaths(int m, int n) {
		int[][] grid = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int top = i > 0 ? (grid[i - 1][j]) : 0;
				int bottom = j > 0 ? (grid[i][j - 1]) : 0;

				grid[i][j] = (i == 0 && j == 0) ? 1 : top + bottom;
			}
		}

		return grid[m - 1][n - 1];
	}

	/*
	 * LeetCode 63
	 * https://leetcode.com/problems/unique-paths-ii/
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int r = obstacleGrid.length;
		int c = obstacleGrid[0].length;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 && j == 0) {
					obstacleGrid[i][j] = obstacleGrid[i][j] == 0 ? 1 : 0;
					continue;
				}

				int left = (j > 0) ? obstacleGrid[i][j - 1] : 0;
				int top = (i > 0) ? obstacleGrid[i - 1][j] : 0;
				obstacleGrid[i][j] = (obstacleGrid[i][j] == 1) ? 0 : left + top;
			}
		}

		return obstacleGrid[r-1][c-1];
	}

}
