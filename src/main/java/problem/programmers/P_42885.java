package problem.programmers;

import java.util.*;

public class P_42885 {
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);

            int right = people.length - 1;
            int left = 0;
            while(left <= right){
                if (people[left] + people[right] <= limit) {
                    left++;
                }
                right--;
                answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{70, 80, 50}, 100);
        System.out.println(solution);

    }
}
