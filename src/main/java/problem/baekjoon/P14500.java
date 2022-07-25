package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P14500 {
    private static int[][][] blocks = {
            {{1,0},{2,0},{3,0}},
            {{0,1},{0,2},{0,3}},
            {{0,1},{1,0},{1,1}},
            {{1, 0},{2,0},{2,1}},
            {{-2,1},{-1,1},{0, 1}},
            {{1,0},{1,1},{2,1}},
            {{-1,1},{0,1},{1,0}},
            {{1,0},{2,0},{0,1}},
            {{0,1},{1,1},{2,1}},
            {{0,1},{0,2},{1,1}},
            {{-1,1},{0,1},{0,2}},
            {{-1,1},{0,1},{1,1}},
            {{1,0},{2,0},{1,1}},
            {{-1,1},{0,1},{-1,2}},
            {{0,1},{1,1},{1,2}},
            {{1,0},{1,1},{1,2}},
            {{0,1},{-1,2},{0,2}},
            {{1,0},{0,1},{0,2}},
            {{0,1},{0,2},{1,2}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] token = br.readLine().split(" ");
        int y = Integer.parseInt(token[0]);
        int x = Integer.parseInt(token[1]);
        int[][] arr = new int[y][x];
        for (int i = 0; i < y; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < x; j++) arr[i][j] = Integer.parseInt(line[j]);
        }
        int ans = 0;
        for(int i =0;i< y;i++){
            for (int j = 0; j < x; j++) {

                for (int k = 0; k < blocks.length; k++) {
                    int[][] block = blocks[k];
                    int check = check(i, j, y, x, block, arr);
                    ans = Math.max(ans,check);
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
    private static int check(int i,int j,int y,int x,int[][] block,int[][] arr){
        int ans = arr[i][j];
        for (int[] ints : block) {
            int ny = ints[0] + i;
            int nx = ints[1] + j;
            if(ny >= y || ny < 0 || nx >= x || nx <0) return -1;
            ans+= arr[ny][nx];
        }
//        System.out.println(i + " " + j);
//        for (int[] b : block) {
//            System.out.print(Arrays.toString(b)+" ");
//        }
//        System.out.println();
//        System.out.println(ans);

        return ans;
    }
}
