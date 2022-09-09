package problem.programmers;

import java.util.Arrays;

public class P_42747 {
    static class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);
            int answer = 0;
            for (int i = citations.length - 1; i >= 0; i--) {
                if (i != 0) {
                    for (int j = citations[i]; j > citations[i - 1]; j--) {
                        if (j <= citations.length - i ) {
                            answer = j;
                            return answer;
                        }
                    }
                } else {
                    for(int j= citations[i] ; j>=0 ;j--)
                        if (j <= citations.length - i) {
                            answer = j;
                            return answer;
                        }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{3, 0, 6, 1, 5});
        System.out.println("solution = " + solution);
    }
}
