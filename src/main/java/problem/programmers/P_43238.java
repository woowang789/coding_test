package problem.programmers;

import java.util.Arrays;

public class P_43238 {
    static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            Arrays.sort(times);

            long left = 0;
            long right = (long) times[times.length - 1] * n;

            while (left <= right) {
                long mid = (left + right) /2;
                long ret = 0;
                for (int time : times)
                    ret += mid / time;
                if (ret >= n) { // 더 많은 사람을 처리할 수 있으면
                    right = mid - 1;
                    answer = mid;
                } else { // n을 처리할 수 없으면
                    left = mid + 1;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution = sol.solution(6, new int[]{7, 10});
        System.out.println(solution);
    }
}
