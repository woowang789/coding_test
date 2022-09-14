package problem.programmers;

public class P_17687 {
    static class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder answer = new StringBuilder();
            int num = 0;
            int turn = 1;
            while (true) {
                String target = Integer.toString(num, n);
                for (char ch : target.toCharArray()) {
                    if(turn == p) {
                        answer.append(Character.isAlphabetic(ch)?Character.toUpperCase(ch):ch);
                        if(answer.length() == t) return answer.toString();
                    }
                    turn++;
                    if(turn > m) turn = 1;
                }
                num++;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution = sol.solution(16, 16, 2, 1);
        System.out.println("solution = " + solution);
    }
}
