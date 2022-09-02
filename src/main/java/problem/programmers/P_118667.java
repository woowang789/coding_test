package problem.programmers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P_118667 {
    static class Solution {
        public int solution(int[] queue1, int[] queue2) {
            long sum1 = 0;
            long sum2 = 0;
            for (int i : queue1) sum1 += i;
            for (int i : queue2) sum2 += i;
            long total = sum1 + sum2;
            if(total%2==1) return -1;
            long goal = total / 2;

            int answer = 0;
            long cur = sum1;
            int left = 0;
            int right = queue1.length;

            while (right < queue1.length+queue2.length) {
                if(cur == goal) return answer;
                else if(cur > goal){
                    int el = left >= queue1.length ? queue2[left - queue1.length] : queue1[left];
                    cur -= el;
                    left++;
                }else{
                    int el = queue2[right - queue2.length];
                    cur += el;
                    right++;
                }
                answer++;
            }
            return goal == cur ? answer : -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
    }
}
