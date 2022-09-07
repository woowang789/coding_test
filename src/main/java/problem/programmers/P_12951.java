package problem.programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P_12951 {
    static class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            if(Character.isAlphabetic(s.charAt(0))) sb.append(Character.toUpperCase(s.charAt(0)));
            else sb.append(s.charAt(0));
            int idx = 1;

            while (idx < s.length()) {
                if( idx-1 >=0 && s.charAt(idx-1)==' ' && Character.isAlphabetic(s.charAt(idx)))
                    sb.append(Character.toUpperCase(s.charAt(idx)));
                else if(Character.isAlphabetic(s.charAt(idx)))
                    sb.append(Character.toLowerCase(s.charAt(idx)));
                else sb.append(s.charAt(idx));
                idx++;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution = sol.solution("3people unFollowed me");
        System.out.println(solution);
    }
}
