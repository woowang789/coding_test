package problem.programmers;

public class P_12924 {
    static class Solution {
        public int solution(int n) {
            if(n < 3) return 1;
            int answer = 1;
            int left = 1;
            int right = 2;
            int sum = left + right;
            while (right < n) {
                if (sum < n) {
                    sum += ++right;
                    continue;
                }
                if (sum == n) answer++;
                sum -= left++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(15);
        System.out.println("solution = " + solution);
    }
}
