package problem.programmers;

import java.util.Arrays;

public class P_42577 {
    static class Solution {
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book, (o1, o2) -> {
                if(o1.compareTo(o2) != 0) return o1.compareTo(o2);
                return o1.length() - o2.length();
            });
            for (int i = 0; i < phone_book.length-1; i++) {
                if (phone_book[i + 1].startsWith(phone_book[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean solution = sol.solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println("solution = " + solution);
    }
}
