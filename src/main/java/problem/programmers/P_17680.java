package problem.programmers;

import java.util.*;

public class P_17680 {
    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            Set<String> set = new HashSet<>();
            Queue<String> que = new LinkedList<>();

            for (String c : cities) {
                String city = c.toLowerCase();
                if(set.contains(city)){
                    Queue<String> tmp = new LinkedList<>();
                    while(!que.isEmpty() && !que.peek().equals(city))
                        tmp.offer(que.poll());
                    que.poll();
                    while(!que.isEmpty() && !que.peek().equals(city))
                        tmp.offer(que.poll());
                    tmp.offer(city);
                    que = tmp;

                    answer++;
                }else{
                    que.offer(city);
                    set.add(city);
                    answer += 5;
                    if(que.size() > cacheSize) set.remove(que.poll());
                }
                System.out.println(que+" "+set+" "+answer);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(5,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA",
                        "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
        System.out.println("solution = " + solution);
    }
}
