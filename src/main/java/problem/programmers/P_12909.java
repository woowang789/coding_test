package problem.programmers;

import java.util.Stack;

public class P_12909 {
    static class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();

            for (Character ch : s.toCharArray()) {
                if(ch == ')'){
                    if(stack.peek() == '(') stack.pop();
                    else return false;
                } else stack.push(ch);
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("(())()"));

    }
}
