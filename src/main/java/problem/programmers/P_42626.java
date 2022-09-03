package problem.programmers;

import java.util.PriorityQueue;

public class P_42626 {
    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> que = new PriorityQueue<>();
            for (int i : scoville) que.offer(i);
            while (que.peek() < K) {
                answer++;
                int a = que.poll();
                if(que.isEmpty()) return -1;
                int b = que.poll();
                que.offer(b * 2 + a);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println(solution);
    }
}
