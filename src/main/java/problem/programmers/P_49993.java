package problem.programmers;

import java.util.HashMap;
import java.util.Map;

public class P_49993 {
    static class Solution {
        Map<Character, Integer> map;
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            map = new HashMap<>();
            for (int i = 0; i < skill.length(); i++) map.put(skill.charAt(i), i);
            for (String skill_tree : skill_trees) {
                if(check(skill_tree)) answer++;
            }
            return answer;
        }

        private boolean check(String skill_tree) {
            int idx = 0;
            int lev = 0;
            while (idx < skill_tree.length()) {
                if(map.containsKey(skill_tree.charAt(idx))){
                    int required = map.get(skill_tree.charAt(idx));
                    if(required>lev) return false;
                    else lev++;
                }
                idx++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int cbd = sol.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println("cbd = " + cbd);
    }
}
