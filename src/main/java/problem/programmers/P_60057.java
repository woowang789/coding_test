package problem.programmers;

public class P_60057 {
    static class Solution {
        public int solution(String s) {
            int answer = s.length();
            for (int token = 1; token <= s.length()/2; token++) {
                int len = 0;
                int idx = 0;
                while (idx + token <= s.length()) {
                    int count = 0;
                    String target = s.substring(idx, idx+token);
                    while (s.length() >= idx + token && target.equals(s.substring(idx, idx + token))) {
                        count++;
                        idx += token;
                    }
                    if(count >1){
                        len += token + Integer.toString(count).length();
                    }else{
                        len+=token;
                    }
                }
                len += s.length() - idx;
                answer = Math.min(len, answer);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("abcabcabcabcdededededede"));
    }
}
