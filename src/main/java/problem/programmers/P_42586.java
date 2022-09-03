package problem.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_42586 {
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();
            int day = 0;
            int idx = 0;
            while (idx < progresses.length) {
                int count = 0;
                day = (int) Math.ceil((100 - progresses[idx]) / (double) speeds[idx]);
                while (idx < progresses.length && 100 <= progresses[idx] + day * speeds[idx]) {
                    idx++;
                    count++;
                }
                answer.add(count);
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));

    }
}
