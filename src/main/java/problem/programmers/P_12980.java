package problem.programmers;

import java.util.Arrays;

public class P_12980 {
    static public class Solution {
        public int solution(int n) {
            int ans = 0;
            while (n != 0) {
                if (n % 2 != 0) {
                    n--;
                    ans++;
                } else {
                    n /= 2;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(5000);
        System.out.println("solution = " + solution);

    }
}
