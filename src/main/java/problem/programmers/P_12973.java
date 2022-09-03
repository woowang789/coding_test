package problem.programmers;

import java.util.Stack;

public class P_12973 {
    static class Solution {
        public int solution(String s) {
            Stack<Character> st = new Stack<>();
            for (char c : s.toCharArray()) {
                if(st.isEmpty()) st.push(c);
                else{
                    if(st.peek() == c) st.pop();
                    else st.push(c);
                }
            }

            return st.isEmpty()?1:0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int baabaa = solution.solution("baabaa");
        System.out.println("baabaa = " + baabaa);

    }
}
