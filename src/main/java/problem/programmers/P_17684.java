package problem.programmers;

import java.util.*;

public class P_17684 {
    static class Solution {
        public int[] solution(String msg) {
            Map<String, Integer> map = new HashMap<>();
            int i = 1;
            char ch = 'A';
            while (ch <= 'Z') {
                map.put(ch + "", i++);
                ch++;
            }
            List<Integer> answer = new ArrayList<>();
            int idx = 0;
            while (idx < msg.length()) {
                int tmp = idx;
                while (tmp < msg.length() && map.containsKey(msg.substring(idx, tmp + 1)))
                    tmp++;
                answer.add(map.get(msg.substring(idx, tmp)));
                if(tmp < msg.length() && !map.containsKey(msg.substring(idx,tmp+1)))
                    map.put(msg.substring(idx, tmp + 1), i++);
                idx = tmp;
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution("TOBEORNOTTOBEORTOBEORNOT");
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }
}
