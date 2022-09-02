package problem.programmers;

import java.util.HashMap;
import java.util.Map;

public class P_118666 {
    static class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            final String a = "RTCFJMAN";
            Map<Character, Integer> alMap = new HashMap<>();
            for (Character ch : a.toCharArray()) alMap.put(ch, 0);
            for (int i = 0; i < survey.length; i++) {
                if(choices[i] < 4){
                    alMap.put(survey[i].charAt(0), alMap.get(survey[i].charAt(0)) + (4 - choices[i]));
                }else if(choices[i] >4){
                    alMap.put(survey[i].charAt(1), alMap.get(survey[i].charAt(1)) + (choices[i] - 4));
                }
            }

            answer+= alMap.get('R') >= alMap.get('T') ? 'R' : 'T' ;
            answer+= alMap.get('C') >= alMap.get('F') ? 'C' : 'F' ;
            answer+= alMap.get('J') >= alMap.get('M') ? 'J' : 'M' ;
            answer+= alMap.get('A') >= alMap.get('N') ? 'A' : 'N' ;

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},new int[]{5, 3, 2, 7, 5}));
    }
}
