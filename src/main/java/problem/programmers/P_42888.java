package problem.programmers;

import java.util.*;

public class P_42888 {
    static class Solution {
        public String[] solution(String[] record) {
            List<String> answer = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            for (String a : record) {
                String[] cmd = a.split(" ");
                if (cmd[0].equals("Enter") || cmd[0].equals("Change")) {
                    map.put(cmd[1], cmd[2]);
                }
            }
            for (String s : record) {
                String[] cmd = s.split(" ");
                if (cmd[0].equals("Enter")) {
                    answer.add(map.get(cmd[1]) + "님이 들어왔습니다.");
                } else if (cmd[0].equals("Leave")) {
                    answer.add(map.get(cmd[1]) + "님이 나갔습니다.");
                }

            }
            return answer.toArray(new String[0]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(
                new String[]{
                        "Enter uid1234 Muzi",
                        "Enter uid4567 Prodo",
                        "Leave uid1234",
                        "Enter uid1234 Prodo",
                        "Change uid4567 Ryan"
                }
        )));
    }
}
