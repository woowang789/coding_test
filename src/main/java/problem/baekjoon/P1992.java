package problem.baekjoon;

import java.io.*;

public class P1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i =0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++) arr[i][j] = line.charAt(j)-'0';
        }
        System.out.println(solve(arr,0,0,n));


        br.close();
    }

    private static String solve(int[][] arr, int y,int x, int size){
        int val = arr[y][x];
        if(check(arr, y, x, size)) return Integer.toString(val);
        StringBuilder sb = new StringBuilder("(");
        String one = solve(arr,y,x,size/2);
        String two = solve(arr,y,x+size/2,size/2);
        String three = solve(arr,y+size/2,x,size/2);
        String four = solve(arr,y+size/2,x+size/2,size/2);
        return sb.append(one).append(two).append(three).append(four).append(")").toString();
    }
    private static boolean check(int[][] arr,int y,int x,int size){
        int val = arr[y][x];
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(arr[i][j] != val) return false;
            }
        }
        return true;
    }
}
