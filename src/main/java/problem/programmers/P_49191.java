package problem.programmers;

import java.util.Arrays;

public class P_49191 {
    static class Solution {
        int[][] board;
         public int solution(int n, int[][] results) {
             int answer = 0;
             board = new int[n + 1][n + 1];
             for (int[] ints : board) {
                 Arrays.fill(ints,1000000);
             }

             for (int[] result : results)
                 board[result[0]][result[1]] = 1;

             for (int k = 1; k <= n; k++) {
                 for (int i = 0; i <= n; i++) {
                     for (int j = 0; j<= n; j++) {
                         if (board[i][j] > board[i][k] + board[k][j]) {
                             board[i][j] = board[i][k] + board[k][j];
                         }
                     }
                 }
             }
             for (int i = 1; i <= n; i++) {
                 int count = 0;
                 for (int j = 1; j <= n; j++) {
                     if(i==j) continue;
                     if(board[i][j] != 1000000 || board[j][i] != 1000000 ) count++;
                 }
                 if(count== n-1) answer++;
             }
            return answer;
        }
    }

//    new int[][]{ new int[]{4, 3}, new int[]{4, 2}, new int[]{3, 2}, new int[]{1, 2}, new int[]{2, 5} }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(5, new int[][]{
                new int[]{4, 3},
                new int[]{4, 2},
                new int[]{3, 2},
                new int[]{1, 2},
                new int[]{2, 5}}
        );
        System.out.println(solution);
    }
}
