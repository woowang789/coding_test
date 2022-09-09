package problem.programmers;

import java.util.Arrays;

public class P_12949 {
    static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[0].length; j++) {
                    for (int r = 0; r < arr2[0].length; r++) {
                        answer[i][r] += arr1[i][j] * arr2[j][r];
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        new int[][]{ new int[]{2, 3, 2}, new int[]{4, 2, 4}, new int[]{3, 1, 4} }
//        new int[][]{ new int[]{5, 4, 3}, new int[]{2, 4, 1}, new int[]{3, 1, 1} }
        int[][] solution = sol.solution(
                new int[][]{new int[]{1, 4}, new int[]{3, 2}, new int[]{4, 1}},
                new int[][]{new int[]{3, 3}, new int[]{3, 3}}
        );
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
