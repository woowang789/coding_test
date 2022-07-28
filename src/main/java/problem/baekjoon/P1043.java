package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P1043 {
    private static int[] parent;
    private static Set<Integer> t = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t1 = br.readLine().split(" ");
        int N = Integer.parseInt(t1[0]); // 사람 수
        int M = Integer.parseInt(t1[1]); // 파티 수
        int ans = 0;
        boolean[] know = new boolean[N];
        int[][] arr = new int[M][];
        parent = new int[N];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < s.length; i++) know[s[i]-1] = true;

        for (int i = 0; i < M; i++) {
            int[] s1 = Arrays.stream(br.readLine().split(" ")).mapToInt(v -> Integer.parseInt(v)-1).toArray();
            arr[i] = Arrays.copyOfRange(s1, 1, s1.length);
            for (int j = 1; j < arr[i].length; j++)
                union(arr[i][j - 1], arr[i][j]);
        }
        for (int i = 0; i < know.length; i++) {
            if(know[i]){ // 아는사람의 부모를 넣음
                t.add(parent[i]);
            }
        }
        for (int i = 0; i < M; i++) if(check(arr[i])) ans++;

        System.out.println(ans);

        br.close();
    }
    private static void union(int a, int b){
        int aP = getParent(a);
        int bP = getParent(b);
        if (aP < bP) { // aP로 통일
            for (int i = 0; i < parent.length; i++) if(parent[i] == bP) parent[i] = aP;
        }else if(aP > bP){
            for (int i = 0; i < parent.length; i++) if(parent[i] == aP) parent[i] = bP;
        }
    }
    private static int getParent(int a){
        if(parent[a]==a) return a;
        return getParent(parent[a]);
    }
    private static boolean check(int[] party){ // 거짓말을 칠수 있는지
        for (int idx : party) { // 파티에 참석한 사람
            if(t.contains(parent[idx])) return false;
        }
        return true;
    }
}
