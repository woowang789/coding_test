package problem.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_77485 {
    static class Solution {
        static int[][] board;
        public int[] solution(int rows, int columns, int[][] queries) {
            board = new int[rows ][columns ];
            List<Integer> answer = new ArrayList<>();
            int num=1;
            for (int i = 0; i < rows ; i++) {
                for (int j = 0; j < columns ; j++) {
                    board[i][j] = num++;
                }
            }
            for (int[] query : queries) answer.add(rotate(query));

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

        private int rotate(int[] query) {
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;

            int tmp = board[x1][y1];
            int min = tmp;
            for (int i = y1; i < y2; i++) {
                int n = board[x1][i+1];
                board[x1][i + 1] = tmp;
                tmp = n;
                min = Math.min(tmp, min);
            }

            for (int i = x1; i < x2; i++) {
                int n = board[i + 1][y2];
                board[i + 1][y2] = tmp;
                tmp = n;
                min = Math.min(tmp, min);
            }

            for (int i = y2; i > y1; i--) {
                int n = board[x2][i - 1];
                board[x2][i - 1] = tmp;
                tmp = n;
                min = Math.min(tmp, min);
            }

            for (int i = x2; i > x1; i--) {
                int n = board[i - 1][y1];
                board[i - 1][y1] = tmp;
                tmp = n;
                min = Math.min(tmp, min);
            }


            return min;
        }

        private void printArr() {
            for (int[] ints : board) {
                System.out.println(Arrays.toString(ints));
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[][]{ int[]{2,2,5,4},int[]{3,3,6,6},int[]{5,1,6,3} }
        int[] solution = sol.solution(6, 6, new int[][]{
                new int[]{2, 2, 5, 4},
                new int[]{3, 3, 6, 6},
                new int[]{5, 1, 6, 3}}
        );
        System.out.println(Arrays.toString(solution));
    }
}
