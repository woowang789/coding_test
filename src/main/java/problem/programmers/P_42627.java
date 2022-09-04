package problem.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_42627 {
    static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            int idx = 0;
            int time = 0;
            while (idx < jobs.length || !que.isEmpty()) {
                while (idx < jobs.length && time >= jobs[idx][0]) {
                    que.offer(jobs[idx]);
                    idx++;
                }
                if(que.isEmpty())
                    time = jobs[idx][0];
                else{
                    int[] poll = que.poll();
                    time += poll[1];
                    answer += time - poll[0];
                }
            }
            return answer/ jobs.length;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        new int[][]{ new int[]{0, 3}, new int[]{1, 9}, new int[]{2, 6} }
        int solution = sol.solution(
                new int[][]{new int[]{0, 3}, new int[]{1, 9}, new int[]{2, 6}}
        );
        System.out.println(solution);
    }
}
