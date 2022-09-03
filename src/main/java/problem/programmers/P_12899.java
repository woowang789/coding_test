package problem.programmers;

public class P_12899 {
    static class Solution {
        static private char[] arr = {0, 1, 2, 4};
        public String solution(int n) {
            StringBuilder answer = new StringBuilder();
            while (n > 0) {
                int a = n % 3;
                if(a == 0) {
                    n -= 3;
                    answer.insert(0, Integer.toString(arr[3]));
                }else {
                    n -= a;
                    answer.insert(0, Integer.toString(arr[a]));
                }
                n /= 3;
            }
            return answer.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4));

    }
}
