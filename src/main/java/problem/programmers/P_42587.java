package problem.programmers;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class P_42587 {
    static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<int[]> que = new LinkedList<>();
            PriorityQueue<Integer> pri = new PriorityQueue<>((o1, o2) -> o2-o1);
            for (int i = 0; i < priorities.length; i++) {
                que.offer(new int[]{priorities[i], i}); // 우선순위 , 인덱스
                pri.offer(priorities[i]);
            }

            int idx=0;
            while (!que.isEmpty()) {
                int target = pri.poll();
                while(que.peek()[0] != target){
                    que.offer(que.poll());
                }
                int[] poll = que.poll();
                idx++;
                if (poll[1] == location) return idx;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println("solution = " + solution);
    }
}
