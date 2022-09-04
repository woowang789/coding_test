package problem.programmers;

import java.util.Arrays;

public class P_42860 {
    static class Solution {
        public int solution(String name) {
            boolean[] b = new boolean[name.length()];
            for (int i = 0; i < name.length(); i++) {
                if(name.charAt(i) == 'A') b[i] = true;
            }
            return solve(name, b, 0, 0);
        }
        private int solve(String name,boolean[] visited, int idx,int count){

            int ret = Integer.MAX_VALUE;

            count += changeTo(name.charAt(idx)); //내 위치 해결
            visited[idx] = true;

            if(checkFin(visited)){
                System.out.println("count = " + count);
                return count;
            }

            int[] left = moveLeft(visited, idx);
            int[] right = moveRight(visited, idx);

            ret = Math.min(ret, solve(name, visited, left[0], count + left[1]));
            visited[left[0]] = false;
            ret = Math.min(ret, solve(name, visited, right[0], count + right[1]));
            visited[right[0]] = false;

            visited[idx] = false;

            return ret;
        }

        private int[] moveRight(boolean[] visited, int idx) {
            int step = 0;
            while(visited[idx]){
                step++;
                idx++;
                if(idx>= visited.length) idx = 0;
            }
            return new int[]{idx,step};
        }

        private int[] moveLeft(boolean[] visited, int idx) {
            int step = 0;
            while(visited[idx]){
                step++;
                idx--;
                if(idx<0) idx = visited.length - 1;
            }
            return new int[]{idx,step};
        }

        private boolean checkFin(boolean[] visited) {
            for (boolean b : visited)
                if(!b) return false;
            return true;
        }

        private int changeTo(Character to) {
            return Math.min(to - 'A', 1 + 'Z' - to);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int jeroen = sol.solution("JAN");
        System.out.println("jeroen = " + jeroen);
    }
}
