package problem.programmers;

import java.util.Arrays;

public class P_42842 {
    static class Solution {
        public int[] solution(int brown, int yellow) {
            for (int i = yellow; i >= 1; i--) {
                if(yellow%i != 0) continue;
                int j = yellow / i;

                if((i+2)*(j+2) - yellow == brown) return new int[]{i + 2, j + 2};
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(10, 2);
        System.out.println(Arrays.toString(solution));
    }
}
