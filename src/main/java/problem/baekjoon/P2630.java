package problem.baekjoon;

import java.io.*;

public class P2630 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] board=  new int[n][n];
        for(int i =0;i<n;i++){
            String[] line = br.readLine().split(" ");
            for(int j=0;j<n;j++) board[i][j] = Integer.parseInt(line[j]);
        }
        int[] ret = solve(board, 0, 0, n);
        bw.write(ret[0]+"\n");
        bw.write(ret[1]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
    // 0 : 흰, 1 : 파
    private static int[] solve(int[][] board,int y,int x,int size){
        if(check(board, y, x, size))
            return board[y][x]==1? new int[]{0,1}:new int[]{1,0};

        int[] one = solve(board,y,x,size/2);
        int[] two = solve(board,y,x+size/2,size/2);
        int[] three = solve(board,y+size/2,x,size/2);
        int[] four = solve(board,y+size/2,x+size/2,size/2);
        return new int[]{one[0]+two[0]+three[0]+four[0],one[1]+two[1]+three[1]+four[1]};

    }
    private static boolean check(int[][] board,int y,int x,int size){
        int val = board[y][x];
        for(int i =y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(board[i][j] != val) return false;
            }
        }
        return true;
    }
}
