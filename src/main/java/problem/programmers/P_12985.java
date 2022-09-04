package problem.programmers;

public class P_12985 {
    static class Solution {
        public int solution(int n, int a, int b) {
            int answer = 0;
            while (a != b) {
                a = (a + 1) / 2;
                b = (b + 1) / 2;
                answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(8, 1, 2);
        System.out.println(solution);
    }
}
