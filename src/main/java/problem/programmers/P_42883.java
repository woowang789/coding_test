package problem.programmers;

public class P_42883 {
    static class Solution {
        public String solution(String number, int k) {
            k = number.length() - k;
            StringBuilder answer = new StringBuilder();
            int idx = 0;
            while (k > 0) {
                char max = '0';
                int tmp = idx;
                for (int i = idx; i < number.length() - k + 1; i++) {
                    if(number.charAt(i) > max){
                        max = number.charAt(i);
                        tmp = i;
                    }
                }
                idx = tmp+1;
                answer.append(max);
                k--;
            }
            return answer.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution = sol.solution("1924", 2);
        System.out.println("solution = " + solution);
    }
}
