package problem.programmers;

import java.util.Queue;

public class P_43163 {
    static class Solution {
        boolean[] visited;
        public int solution(String begin, String target, String[] words) {
            visited = new boolean[words.length];
            int answer = solve(words, begin, target, 0);

            return answer == Integer.MAX_VALUE ? 0 : answer;
        }

        private int solve(String[] words, String cur,String target,int count) {
            if(cur.equals(target)) return count;
            int ret = Integer.MAX_VALUE;
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(cur, words[i])) {
                    visited[i] = true;
                    ret = Math.min(ret, solve(words, words[i], target, count + 1));
                    visited[i] = false;
                }
            }
            return ret;
        }

        private boolean canChange(String str1, String str2) {
            int count = 0;
            for (int i = 0; i < str1.length(); i++) {
                if(str1.charAt(i) != str2.charAt(i)) count++;
                if(count>1) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log"});
        System.out.println("solution = " + solution);
    }
}
