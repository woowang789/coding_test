package problem.programmers;

import java.util.*;

public class P_76502 {
    static class Solution {
        public int solution(String s) {
            int answer = 0;
            int idx = 0;
            while (idx < s.length()) {
                if(valid(s,idx)) answer++;
                idx++;
            }
            return answer;
        }

        private boolean valid(String s, int start) {
            Stack<Character> st = new Stack<>();
            for (int i = start; i < s.length(); i++) {
                if(st.isEmpty()) st.push(s.charAt(i));
                else{
                    if(s.charAt(i)==')' && st.peek() == '(') st.pop();
                    else if(s.charAt(i)=='}' && st.peek() == '{') st.pop();
                    else if(s.charAt(i)==']' && st.peek() == '[') st.pop();
                    else st.push(s.charAt(i));
                }
            }
            for (int i = 0; i < start; i++) {
                if(st.isEmpty()) st.push(s.charAt(i));
                else{
                    if(s.charAt(i)==')' && st.peek() == '(') st.pop();
                    else if(s.charAt(i)=='}' && st.peek() == '{') st.pop();
                    else if(s.charAt(i)==']' && st.peek() == '[') st.pop();
                    else st.push(s.charAt(i));
                }
            }
            return st.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution("}]()[{");
        System.out.println("solution = " + solution);
    }
}
