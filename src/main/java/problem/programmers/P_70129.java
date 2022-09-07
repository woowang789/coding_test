package problem.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_70129 {
    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];
            int c = 0;
            int round = 0;
            while (!s.equals("1")) {
                round++;
                int a = 0;
                for (int i = 0; i < s.length(); i++)
                    if(s.charAt(i) == '1') a++;
                c += s.length() - a;
                s = Integer.toString(a, 2);
            }
            answer[0] = round;
            answer[1] = c;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution("1111111");
        System.out.println(Arrays.toString(solution));
    }
}
