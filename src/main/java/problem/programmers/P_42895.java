package problem.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_42895 {
    static class Solution {
        public int solution(int N, int number) {
            int answer = -1;

            Queue<int[]> que = new LinkedList<>();
            que.add(new int[]{0, 0});
            while(!que.isEmpty()){
                int[] cur = que.poll();
                if(cur[0] == number) return cur[1];
                if(cur[1] > 8) return -1;

                int tmp = 0;
                for (int i = cur[1]+1; i <= 8; i++) {
                    tmp = tmp * 10 + N;

                    que.offer(new int[]{cur[0] + tmp, i});
                    que.offer(new int[]{cur[0] - tmp, i});
                    que.offer(new int[]{cur[0] / tmp, i});
                    que.offer(new int[]{cur[0] * tmp, i});
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        5, 31168
        int solution = sol.solution(5, 31168);
        System.out.println("solution = " + solution);
    }
}
