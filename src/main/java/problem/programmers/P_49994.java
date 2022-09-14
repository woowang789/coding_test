package problem.programmers;

public class P_49994 {
    static class Solution {
        int[][] board;
        boolean[][][] visited;
        final int SIZE = 11;
        public int solution(String dirs) {
            board = new int[SIZE][SIZE];
            visited = new boolean[SIZE][SIZE][4];
            int answer = 0;
            int y = 5;
            int x = 5;
            for (char dir : dirs.toCharArray()) {
                if (dir == 'U') {
                    if(y+1<SIZE){
                        if(!visited[y][x][0]) answer++;
                        visited[y][x][0] = true;
                        visited[y + 1][x][1] = true;
                        y++;
                    }
                }else if(dir == 'D'){
                    if(y-1 >=0){
                        if(!visited[y][x][1]) answer++;
                        visited[y][x][1] = true;
                        visited[y - 1][x][0] = true;
                        y--;
                    }
                }else if(dir=='L'){
                    if (x - 1 >= 0) {
                        if(!visited[y][x][2]) answer++;
                        visited[y][x][2] = true;
                        visited[y][x - 1][3] = true;
                        x--;
                    }
                }else if(dir == 'R'){
                    if (x + 1 < SIZE) {
                        if (!visited[y][x][3]) answer++;
                        visited[y][x][3] = true;
                        visited[y][x + 1][2] = true;
                        x++;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ulurrdllu = sol.solution("LULLLLLLU");
        System.out.println("LULLLLLLU = " + ulurrdllu);
    }
}
