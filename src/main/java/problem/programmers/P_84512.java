package problem.programmers;

public class P_84512 {
    static class Solution {
        char[] aeiou = new char[]{'A', 'E', 'I', 'O', 'U'};
        int count = 0;
        boolean fin = false;
        public int solution(String word) {
            dfs(0, "", word);
            return count;
        }

        private void dfs(int depth, String next, String target) {
            if(depth == 6) return;
            if (next.equals(target)) {
                fin = true;
                return;
            }
            for (int i = 0; i < aeiou.length; i++) {
                if(fin) return;
                if(depth+1 < 6) count++;
                dfs(depth + 1, next + aeiou[i], target);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int eio = sol.solution("EIO");
        System.out.println("eio = " + eio);
    }
}
