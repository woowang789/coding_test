package problem.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_87390 {
    static class Solution {
        public int[] solution(int n, long left, long right) {
            int[] answer = new int[(int) (right - left)+1];
            int idx = 0;
            for (long target = left; target <= right; target++) {
                long rowIdx = target / n;
                long colIdx = target % n;
                if(rowIdx < colIdx) answer[idx] = (int) colIdx + 1;
                else answer[idx] = (int) rowIdx + 1;
                idx++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(4, 7, 14);
        System.out.println(Arrays.toString(solution));
    }
}
