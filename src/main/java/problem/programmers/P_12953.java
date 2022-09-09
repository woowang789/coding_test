package problem.programmers;

import java.util.HashMap;
import java.util.Map;

public class P_12953 {
    static class Solution {
        static Map<Integer, Integer> map;
        public int solution(int[] arr) {
            map = new HashMap<>();
            for (int i : arr) {
                setMap(i);
            }
            int answer = 1;
            for (Integer integer : map.keySet())
                answer *= Math.pow( integer,map.get(integer));
            return answer;
        }
        private void setMap(int a){
            Map<Integer, Integer> map1 = new HashMap<>();
            while (a != 1) {
                for (int i = 2; i <= a; i++) {
                    if(a%i == 0){
                        map1.put(i, map1.getOrDefault(i, 0) + 1);
                        a /= i;
                        break;
                    }
                }
            }
            for (Integer i : map1.keySet()) {
                map.put(i, Math.max(map.getOrDefault(i, 0), map1.get(i)));
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{2, 6, 8, 14});
        System.out.println("solution = " + solution);
    }
}
