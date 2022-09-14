package problem.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class P_17679 {
    static class Solution {
        static class Pos{
            int y;
            int x;
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                Pos pos = (Pos) o;
                if (y != pos.y) return false;
                return x == pos.x;
            }
            @Override
            public int hashCode() {
                int result = y;
                result = 31 * result + x;
                return result;
            }

            public Pos(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }

        char[][] list;
        public int solution(int m, int n, String[] board) {
            list = new char[m][n];
            for (int i = 0; i < m; i++) list[i] = board[i].toCharArray();

            int answer = 0;
            while (true) {
                int solve = solve(m, n);
                if(solve == 0) return answer;
                answer += solve;
            }
        }
        private int solve(int m, int n) {
            Set<Pos> set = new HashSet<>();
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (list[i][j] != '.' && check(i, j)) {
                        set.add(new Pos(i, j));
                        set.add(new Pos(i + 1, j));
                        set.add(new Pos(i + 1, j + 1));
                        set.add(new Pos(i, j + 1));
                    }
                }
            }
            for (Pos pos : set)
                list[pos.y][pos.x] = '.';
            for (int j = 0; j < n; j++) {
                Stack<Character> st = new Stack<>();
                for (int i = 0; i < m; i++)
                    if(list[i][j] != '.') st.push(list[i][j]);
                for (int i = m-1; i >=0; i--) {
                    if(!st.isEmpty()) list[i][j] = st.pop();
                    else list[i][j] = '.';
                }
            }
            return set.size();
        }

        private boolean check(int y, int x) {
            char ch = list[y][x];
            if (ch == list[y + 1][x] && ch == list[y + 1][x + 1] && ch == list[y][x + 1]) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(6, 6, new String[]{
                "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"
        });
        System.out.println("solution = " + solution);
    }
}
