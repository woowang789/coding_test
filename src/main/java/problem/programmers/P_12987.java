package problem.programmers;

import java.util.Arrays;

public class P_12987 {
    static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);
            int left = 0;
            int right = B.length - 1;
            for (int i = A.length - 1; i >= 0; i--) {
                if(A[i] >= B[right]) left++;
                else {
                    right--;
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{5, 1, 3, 7},
                new int[]{2, 2, 6, 8}
        );
        System.out.println("solution = " + solution);
    }
}
