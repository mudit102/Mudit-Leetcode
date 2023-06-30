
class Solution {
    public boolean isPossible(int mid, int n, int m, int[][] cells) {
        int[][] grid = new int[n][m];
        for (int i = 0; i < mid; i++) {
            int row = cells[i][0] - 1;
            int col = cells[i][1] - 1;
            grid[row][col] = 1;
        }

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        for (int col = 0; col < m; col++) {
            if (grid[0][col] == 0) {
                stack.push(new Pair<>(0, col));
            }
        }

        while (!stack.isEmpty()) {
            Pair<Integer, Integer> curr = stack.pop();
            int row = curr.getKey();
            int col = curr.getValue();

            if (row == n - 1) {
                return true;
            }

            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);

            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0) {
                    stack.push(new Pair<>(newRow, newCol));
                }
            }
        }

        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1;
        int right = cells.length;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(mid, row, col, cells)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
