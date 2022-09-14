package problem.programmers;

import java.util.Arrays;

public class P_42898 {
    static class Solution {
        int[][] board;
        public int solution(int m, int n, int[][] puddles) {
            board = new int[n][m];
            for (int[] puddle : puddles) {
                int x = puddle[0] - 1;
                int y = puddle[1] - 1;
                board[y][x] = -1;
            }
            for (int i = 0; i < n; i++) {
                if(board[i][0] == -1) break;
                board[i][0] = 1;
            }
            for (int i = 0; i < m; i++) {
                if(board[0][i] == -1) break;
                board[0][i] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if(board[i][j] == -1) continue;
                    int val = 0;
                    if(board[i-1][j] != -1) val += board[i - 1][j]%1000000007;
                    if(board[i][j-1] != -1) val += board[i][j - 1]%1000000007;
                    board[i][j] = val%1000000007;
                }
            }
            return board[n - 1][m - 1];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(4, 3,
                new int[][]{
                        new int[]{2, 2}}
        );
        System.out.println("solution = " + solution);
    }
}
