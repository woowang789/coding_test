package problem.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_42583 {
    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int idx = 0;
            int total = 0;
            Queue<int[]> que = new LinkedList<>(); // 0: w / 1: day
            while (idx < truck_weights.length) {
                answer++;

                if(!que.isEmpty() && answer-que.peek()[1] == bridge_length) {
                    int[] poll = que.poll();
                    total -= poll[0];
                }
                if (total + truck_weights[idx] <= weight && que.size()< bridge_length) { //다음 트럭을 채울 수 있을 떄
                    total += truck_weights[idx];
                    que.offer(new int[]{truck_weights[idx], answer});
                    idx++;
                }else{ // 다음 트럭을 채울 수 없을 떄
                    int[] peek = que.peek();
                    answer += bridge_length - (answer - peek[1])-1;
                }
            }
            while (!que.isEmpty()) {
                int[] poll = que.poll();
                answer += bridge_length - (answer - poll[1]);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
        System.out.println("solution = " + solution);
    }
}
