package problem.programmers;

import java.util.*;

public class P_77486 {
    static class Solution {
        Map<String, String> map;
        Map<String, Integer> price;
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            List<Integer> answer = new ArrayList<>();
            map = new HashMap<>();
            price = new HashMap<>();
            price.put("-", 0);
            for (int i = 0; i < enroll.length; i++) {
                map.put(enroll[i], referral[i]);
                price.put(enroll[i], 0);
            }
            for (int i = 0; i < seller.length; i++) solve(seller[i], amount[i] * 100);

            for (String s : enroll) answer.add(price.get(s));

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

        private void solve(String key, int val) {
            if(!map.containsKey(key)) return;
            String parent = map.get(key);
            if(val < 10)
                price.put(key, price.get(key) + val);
            else {
                int t = val / 10;
                price.put(key, price.get(key) + val - t);
                solve(parent,t);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10});
        System.out.println(Arrays.toString(solution));
    }
}
