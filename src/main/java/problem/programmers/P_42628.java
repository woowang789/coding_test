package problem.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P_42628 {
    static class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            PriorityQueue<Integer> que = new PriorityQueue<>();
            for (String operation : operations) {
                String[] s = operation.split(" ");
                String cmd = s[0];
                int num = Integer.parseInt(s[1]);
                if (cmd.equals("I")) {
                    que.offer(num);
                }else{
                    if(que.isEmpty()) continue;
                    if(num == -1) que.poll();
                    else if(num == 1){
                        PriorityQueue<Integer> tmp = new PriorityQueue<>();
                        while(que.size()>1) tmp.offer(que.poll());
                        que = tmp;
                    }
                }
                System.out.println(que);
            }
            int max = 0;
            int min = 0;
            if(!que.isEmpty()){
                int t = que.poll();
                if(que.size()==0){
                    min = t;
                    max = t;
                }else{
                    min  = t;
                    while(que.size()>1) que.poll();
                    max = que.poll();
                }
            }
            answer[0] = max;
            answer[1] = min;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                Arrays.toString(sol.solution(
                        new String[]{"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"}
                ))
        );
    }
}
