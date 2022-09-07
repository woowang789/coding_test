package problem.programmers;

import java.util.Arrays;

public class P_12941 {
    static class Solution {
        public int solution(int []A, int []B) {
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);

            for (int i = 0; i < A.length; i++) {
                int c = A.length -1 - i;
                answer += A[i] * B[c];
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
        System.out.println("solution = " + solution);
    }
}
