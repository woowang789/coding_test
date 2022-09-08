package problem.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_12981 {
    static class Solution {
        public int[] solution(int n, String[] words) {
            Set<String> used = new HashSet<>();
            int[] answer = new int[]{0, 0};

            used.add(words[0]);
            int idx = 1;
            int turn = 1;
            int round = 1;
            while (idx < words.length) {
                if(words[idx].charAt(0) != words[idx-1].charAt(words[idx-1].length()-1)){
                    return new int[]{turn%n + 1, round};
                }
                if(used.contains(words[idx])){
                    return new int[]{turn%n + 1, round};
                } else used.add(words[idx]);

                idx++;
                turn++;
                if(turn == n){
                    turn = 0;
                    round++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(3,
                new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        System.out.println(Arrays.toString(solution));
    }
}
