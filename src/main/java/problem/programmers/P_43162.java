package problem.programmers;

import java.util.Arrays;

public class P_43162 {
    static class Solution {
        static int[] parent;
        public int solution(int n, int[][] computers) {
            int answer = 0;
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            for (int i = 0; i < computers.length; i++) {
                for (int j = 0; j < computers[0].length; j++) {
                    if(computers[i][j] ==0 || parent[i] == parent[j]) continue;
                    connect(i, j);
                }
            }
            return (int)Arrays.stream(parent).distinct().count();
        }

        private void connect(int a,int b) {
            int aP = getParent(a);
            int bP = getParent(b);
            if(aP > bP){ // bP로 통일
                for (int i = 0; i < parent.length; i++) if(parent[i] == aP) parent[i] = bP;
            }else{
                for (int i = 0; i < parent.length; i++) if(parent[i] == bP) parent[i] = aP;
            }
        }
        private int getParent(int a){
            if(parent[a] == a) return a;
            return getParent(parent[a]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        new int[][]{ new int[]{1, 1, 0}, new int[]{1, 1, 0}, new int[]{0, 0, 1} }
        int solution = sol.solution(3, new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 1, 0},
                new int[]{0, 0, 1}}
        );
        System.out.println("solution = " + solution);
    }
}
