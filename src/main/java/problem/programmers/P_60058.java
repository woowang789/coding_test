package problem.programmers;

import java.util.Stack;

public class P_60058 {
    static class Solution {
        public String solution(String p) {
            String answer = "";
            String solve = solve(p);

            return solve;
        }

        private String solve(String p) {
            if(p.length()==0) return "";
            int idx=0;
            int tmp = 0;
            Stack<Character> st = new Stack<>();
            for (; idx < p.length(); idx++) {
                if(p.charAt(idx) == '(') {
                    st.push('(');
                    tmp++;
                } else{
                    tmp--;
                    if(!st.isEmpty() && st.peek()=='(') st.pop();
                    else st.push(')');
                }
                if(tmp == 0) break;
            }
            if(st.isEmpty())  // 올바른
                return p.substring(0, idx + 1) + solve(p.substring(idx + 1));
            StringBuilder u = new StringBuilder(p.substring(0, idx + 1));
            StringBuilder v = new StringBuilder(p.substring(idx + 1));
            StringBuilder res = new StringBuilder("(")
                    .append(solve(v.toString())).append(")");
            String tmpU = u.deleteCharAt(0)
                    .deleteCharAt(u.length() - 1).toString();
            StringBuilder t = new StringBuilder();
            for (char ch : tmpU.toCharArray()) {
                if(ch=='(') t.append(")");
                else t.append("(");
            }
            return res.toString() + t.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution = sol.solution("()))((()");
        System.out.println(solution);
    }
}
